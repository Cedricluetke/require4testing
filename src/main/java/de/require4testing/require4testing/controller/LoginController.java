package de.require4testing.require4testing.controller;

import de.require4testing.require4testing.model.Rolle;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(
            @RequestParam Rolle rolle,
            @RequestParam String password,
            HttpSession session,
            Model model
    ) {
        if (!rolle.matchesPassword(password)) {
            model.addAttribute("error", "Falsches Passwort");
            return "login";
        }

        session.setAttribute("rolle", rolle);
        return "redirect:/requirements";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}