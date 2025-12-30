package de.require4testing.require4testing.controller;

import de.require4testing.require4testing.model.Requirement;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RequirementController {

    @GetMapping("/requirements")
    public String showRequirements(Model model) {

        Requirement req = new Requirement(
                1L,
                "MVP muss laufen",
                "Der Benutzer soll eine Anforderung per HTML angezeigt bekommen.."
        );

        model.addAttribute("requirement", req);
        return "requirements";
    }
}