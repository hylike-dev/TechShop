package com.app.e_commer.controller.auth;

import com.app.e_commer.dto.auth.RegisterRequest;
import com.app.e_commer.service.inter.AuthService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    private final AuthService authService;

    // Dependency Injection qua Constructor
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        return "auth/login";
    }

    @PostMapping("/login")
    public String handleLogin() {
        return "redirect:/?loginSuccess=true";
    }

    // 1. Hiển thị trang đăng ký
    @GetMapping("/register")
    public String registerPage(Model model) {
        if (!model.containsAttribute("registerRequest")) {
            model.addAttribute("registerRequest", new RegisterRequest());
        }
        return "auth/register";
    }

    // 2. Xử lý yêu cầu đăng ký tài khoản từ Form POST
    @PostMapping("/register")
    public String handleRegister(
            @Valid @ModelAttribute("registerRequest") RegisterRequest registerRequest,
            BindingResult bindingResult,
            Model model,
            RedirectAttributes redirectAttributes) {

        // Kiểm tra xem dữ liệu nhập vào có vi phạm ràng buộc validation không
        if (bindingResult.hasErrors()) {
            return "auth/register"; // Nếu có lỗi, quay lại trang register để hiển thị lỗi
        }

        try {
            // Gọi AuthService để thực hiện đăng ký người dùng mới
            authService.register(registerRequest);
            // Thêm thông báo thành công và chuyên hướng sang trang đăng nhập
            redirectAttributes.addFlashAttribute("successMessage", "Đăng ký tài khoản thành công! Vui lòng đăng nhập.");
            return "redirect:/login";
        } catch (RuntimeException ex) {
            // Bắt lỗi trùng email từ Service và gửi thông báo ra màn hình
            model.addAttribute("errorMessage", ex.getMessage());
            return "auth/register";
        }
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
