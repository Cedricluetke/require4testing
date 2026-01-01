package de.require4testing.controller;

import de.require4testing.require4testing.model.Requirement;
import de.require4testing.require4testing.model.Testrun;
import de.require4testing.require4testing.service.TestrunService;
import de.require4testing.require4testing.service.RequirementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class RequirementController {

    private final RequirementService requirementService;
    private final TestrunService testrunService;

    public RequirementController(RequirementService requirementService, TestrunService testrunService) {
        this.requirementService = requirementService;
        this.testrunService = testrunService;
    }

    @GetMapping("/requirements")
    public String showRequirements(
            @RequestParam(defaultValue = "0") int page,
            Model model
    ) {
        int pageSize = 10;

        List<Requirement> requirements =
                requirementService.getRequirements(page, pageSize);

        int totalPages = requirementService.getTotalPages(pageSize);

        model.addAttribute("requirements", requirements);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);

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
        List<Testrun> testRuns = testrunService.findByTestcaseId(tcId);

        model.addAttribute("testRuns", testRuns);
        model.addAttribute("testcaseId", tcId);
        model.addAttribute("requirementId", reqId);

        return "testruns";
    }
}