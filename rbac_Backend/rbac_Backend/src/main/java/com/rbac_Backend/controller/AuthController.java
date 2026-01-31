package com.rbac_Backend.controller;

import com.rbac_Backend.dto.AuthResponse;
import com.rbac_Backend.dto.LoginRequest;
import com.rbac_Backend.dto.RegisterRequest;
import com.rbac_Backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService service;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(
            @RequestBody RegisterRequest request
            ){
        service.register(request);
        return ResponseEntity.ok("User Register");
    }
    
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> loginUser(
            @RequestBody LoginRequest request
            ){
        return ResponseEntity.ok(service.login(request));
    }
}
