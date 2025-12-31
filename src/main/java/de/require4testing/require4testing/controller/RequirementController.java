package de.require4testing.controller;

import de.require4testing.model.Requirement;
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

    public RequirementController(RequirementService requirementService) {
        this.requirementService = requirementService;
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
}