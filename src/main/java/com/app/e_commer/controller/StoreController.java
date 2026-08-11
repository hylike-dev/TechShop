package com.app.e_commer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StoreController {

    @GetMapping("/store")
    public String store(@RequestParam(value = "category", required = false) String category,
                        @RequestParam(value = "brand", required = false) String brand,
                        @RequestParam(value = "promo", required = false) Boolean promo,
                        Model model) {
        if (Boolean.TRUE.equals(promo)) {
            model.addAttribute("activeNav", "promo");
        } else {
            model.addAttribute("activeNav", "store");
        }
        model.addAttribute("selectedCategory", category);
        model.addAttribute("selectedBrand", brand);
        return "store";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam(value = "id", required = false, defaultValue = "1") Long id, Model model) {
        model.addAttribute("activeNav", "store");
        model.addAttribute("productId", id);
        return "detail";
    }
}
