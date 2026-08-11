package com.app.e_commer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String loginPage(Model model) {
        return "auth/login";
    }

    @PostMapping("/login")
    public String handleLogin() {
        return "redirect:/?loginSuccess=true";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        return "auth/register";
    }

    @PostMapping("/register")
    public String handleRegister() {
        return "redirect:/login?registerSuccess=true";
    }

    @GetMapping("/auth/recover")
    public String recoverPage(Model model) {
        return "auth/recover";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login";
    }
}
