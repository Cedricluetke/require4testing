package de.require4testing.require4testing.controller;

import de.require4testing.require4testing.model.*;
import de.require4testing.require4testing.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class TestrunController {

    private final TestrunService testrunService;
    private final TestcaseService testcaseService;
    private final TesterService testerService;

    public TestrunController(
            TestrunService testrunService,
            TestcaseService testcaseService,
            TesterService testerService
    ) {
        this.testrunService = testrunService;
        this.testcaseService = testcaseService;
        this.testerService = testerService;
    }
    @GetMapping("/requirements/{reqId}/testcases/{tcId}/testruns")
    public String showTestRuns(
            @PathVariable Long reqId,
            @PathVariable Long tcId,
            Model model
    ) {
        Testcase testcase = testcaseService.findById(tcId);
        List<Testrun> testRuns = testrunService.findByTestcase(testcase);
        List<Tester> testers = testerService.findAll();

        model.addAttribute("testRuns", testRuns);
        model.addAttribute("testcase", testcase);
        model.addAttribute("testers", testers);
        model.addAttribute("requirementId", reqId);

        return "testruns";
    }
    @PostMapping("/requirements/{reqId}/testcases/{tcId}/testruns")
    public String createTestRun(
            @PathVariable Long reqId,
            @PathVariable Long tcId,
            @RequestParam Long testerId
    ) {
        Testcase testcase = testcaseService.findById(tcId);
        Tester tester = testerService.findById(testerId);

        Testrun testrun = new Testrun(
                LocalDate.now(),
                tester,
                testcase
        );

        testrunService.save(testrun);

        return "redirect:/requirements/" + reqId + "/testcases/" + tcId + "/testruns";
    }
}
