package de.require4testing.controller;

import de.require4testing.require4testing.model.Requirement;
import de.require4testing.require4testing.model.Testrun;
import de.require4testing.require4testing.model.Testcase;
import de.require4testing.require4testing.service.RequirementService;
import de.require4testing.require4testing.service.TestrunService;
import de.require4testing.require4testing.service.TestcaseService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RequirementController {

    private final RequirementService requirementService;
    private final TestrunService testrunService;
    private final TestcaseService testcaseService;

    public RequirementController(
            RequirementService requirementService,
            TestrunService testrunService,
            TestcaseService testcaseService
    ) {
        this.requirementService = requirementService;
        this.testrunService = testrunService;
        this.testcaseService = testcaseService;
    }


    @GetMapping("/requirements")
    public String showRequirements(
            @RequestParam(defaultValue = "0") int page,
            Model model
    ) {
        int pageSize = 10;

        Page<Requirement> requirementPage =
                requirementService.findPaginated(page, pageSize);

        model.addAttribute("requirements", requirementPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", requirementPage.getTotalPages());

        return "requirements";
    }

    @GetMapping("/requirements/{id}")
    public String showRequirementDetail(@PathVariable Long id, Model model) {
        Requirement req = requirementService.findById(id);
        model.addAttribute("requirement", req);
        return "testcase";
    }

    @GetMapping("/requirements/{reqId}/testcases/{tcId}/testruns")
    public String showTestRuns(
            @PathVariable Long reqId,
            @PathVariable Long tcId,
            Model model
    ) {
        Testcase testcase = testcaseService.findById(tcId);
        List<Testrun> testRuns = testrunService.findByTestcase(testcase);

        model.addAttribute("testRuns", testRuns);
        model.addAttribute("testcase", testcase);
        model.addAttribute("requirementId", reqId);

        return "testruns";
    }
}