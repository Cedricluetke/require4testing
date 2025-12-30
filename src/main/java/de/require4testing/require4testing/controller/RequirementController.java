package de.require4testing.controller;

import de.require4testing.model.Requirement;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RequirementController {

    @GetMapping("/requirements")
    public String showRequirements(Model model) {

        List<Requirement> requirements = new ArrayList<>();
        requirements.add(new Requirement(1L, "GitHub verknüpfen", "Das Repository muss auf GitHub verfügbar und öffentlich sein"));
        requirements.add(new Requirement(2L, "Minimum Viable Product", "MVC-Konzept soll umgesetzt und lauffähig gemacht werden."));
        requirements.add(new Requirement(3L, "Liste von Anforderungen", "Es sollen mehrere (noch hard gecodete) Anforderungen auf der Seite angezeigt werden."));

        model.addAttribute("requirements", requirements);

        return "requirements";
    }
}