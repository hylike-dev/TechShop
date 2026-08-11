package com.app.e_commer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {

    @GetMapping("/cart")
    public String cart(Model model) {
        model.addAttribute("activeNav", "cart");
        return "cart";
    }

    @GetMapping("/payment")
    public String payment(Model model) {
        model.addAttribute("activeNav", "payment");
        return "payment";
    }
}
