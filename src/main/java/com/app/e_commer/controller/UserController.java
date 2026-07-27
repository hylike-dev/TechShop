package com.app.e_commer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/profile")
    public String profile(Model model) {
        return "info_users/info_user";
    }

    @GetMapping("/orders")
    public String orders(Model model) {
        return "info_users/my_orders";
    }

    @GetMapping("/detail-order")
    public String detailOrder(Model model) {
        return "info_users/detail_order";
    }

    @GetMapping("/addresses")
    public String addresses(Model model) {
        return "info_users/addresses";
    }

    @GetMapping("/favorites")
    public String favorites(Model model) {
        return "info_users/favorites";
    }

    @GetMapping("/reviews")
    public String reviews(Model model) {
        return "info_users/evaluate";
    }
}
