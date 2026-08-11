package com.app.e_commer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("")
    public String dashboard(Model model) {
        return "admin/admin_dashboard";
    }

    @GetMapping("/products")
    public String products(Model model) {
        return "admin/manage_product";
    }

    @GetMapping("/categories")
    public String categories(Model model) {
        return "admin/manage_category";
    }

    @GetMapping("/orders")
    public String orders(Model model) {
        return "admin/manage_orders";
    }

    @GetMapping("/accounts")
    public String accounts(Model model) {
        return "admin/manage_accounts";
    }

    @GetMapping("/banners")
    public String banners(Model model) {
        return "admin/manage_banner";
    }

    @GetMapping("/promotions")
    public String promotions(Model model) {
        return "admin/manage_promotions";
    }
}
