package de.require4testing.require4testing.controller;


import de.require4testing.require4testing.model.Requirement;
import de.require4testing.require4testing.model.Testcase;
import de.require4testing.require4testing.repository.RequirementRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

@Controller
public class TestcaseController {

    private final RequirementRepository requirementRepository;

    public TestcaseController(RequirementRepository requirementRepository) {
        this.requirementRepository = requirementRepository;
    }

    @GetMapping("/requirements/{reqId}/testcases/new")
    public String showCreateForm(
            @PathVariable Long reqId,
            Model model
    ) {
        Requirement requirement = requirementRepository
                .findById(reqId)
                .orElseThrow();

        Testcase testcase = new Testcase();
        testcase.setRequirement(requirement);

        model.addAttribute("testcase", testcase);
        model.addAttribute("requirement", requirement);

        return "testcase-form";
    }
}