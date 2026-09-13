package com.app.e_commer.service.inter;

import com.app.e_commer.dto.auth.LoginRequest;
import com.app.e_commer.dto.auth.RegisterRequest;
import com.app.e_commer.entities.User;

public interface AuthService {
    User login(LoginRequest loginRequest);
    User register(RegisterRequest registerRequest);
}