package com.app.e_commer.service.inter.impl;

import com.app.e_commer.dto.auth.LoginRequest;
import com.app.e_commer.dto.auth.RegisterRequest;
import com.app.e_commer.entities.User;
import com.app.e_commer.repositories.UserRepository;
import com.app.e_commer.service.inter.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User login(LoginRequest login) {
        return null;
    }

    @Override
    public User register(RegisterRequest regis) {
        if (userRepository.existsByEmail(regis.getEmail())) {
            throw new RuntimeException("Email đã được sử dụng. Vui lòng chọn Email khác!");
        }

        String defaultRole = "USER";
        User user = new User();
        user.setEmail(regis.getEmail());
        user.setPassword(passwordEncoder.encode(regis.getPassword()));
        user.setFullName(regis.getFullName());
        user.setRole(defaultRole);
        user.setPhone(regis.getPhone());

        return userRepository.save(user);
    }
}
