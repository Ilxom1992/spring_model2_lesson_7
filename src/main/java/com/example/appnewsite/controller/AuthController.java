package com.example.appnewsite.controller;

import com.example.appnewsite.payload.ApiResponse;
import com.example.appnewsite.payload.RegisterDto;
import com.example.appnewsite.service.AuthService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {


    final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public HttpEntity<?>registerUser(@Valid @RequestBody RegisterDto registerDto){
        ApiResponse register = authService.register(registerDto);
        return ResponseEntity.status(register.isSuccess() ? 200:409).body(register);
    }
}
