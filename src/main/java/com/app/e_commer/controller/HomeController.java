package com.app.e_commer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("activeNav", "home");
        return "index";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("activeNav", "about");
        return "about_us";
    }

    @GetMapping("/blog")
    public String blog(Model model) {
        model.addAttribute("activeNav", "blog");
        return "blog";
    }

    @GetMapping("/blog/{id}")
    public String blogDetail(@PathVariable("id") Long id, Model model) {
        model.addAttribute("activeNav", "blog");
        return "blog_detail";
    }
}
