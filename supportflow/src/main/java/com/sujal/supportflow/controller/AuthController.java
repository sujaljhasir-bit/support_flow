package com.sujal.supportflow.controller;

import com.sujal.supportflow.dto.LoginRequest;
import com.sujal.supportflow.dto.RegisterRequest;
import com.sujal.supportflow.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(
            @RequestBody RegisterRequest request
    ) {

        authService.register(request);

        return ResponseEntity.ok("Registration successful");
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestBody LoginRequest request
    ) {

        String token=authService.login(request);

        return ResponseEntity.ok(token);
    }
}