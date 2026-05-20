package com.example.pet_shop.controller;

import com.example.pet_shop.entity.SattarbekSymbatUser;
import com.example.pet_shop.service.SattarbekSymbatUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class SattarbekSymbatAuthController {

    private final SattarbekSymbatUserService userService;


    @PostMapping("/register")
    public Map<String, String> register(
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String name
    ) {
        SattarbekSymbatUser user = userService.createUser(email, password, name);
        Map<String, String> response = new HashMap<>();
        response.put("message", "User registered successfully");
        response.put("email", user.getEmail());
        return response;
    }

    @PostMapping("/login")
    public Map<String, String> login(
            @RequestParam String email,
            @RequestParam String password
    ) {
        SattarbekSymbatUser user = userService.findByEmail(email).orElse(null);


        if (user == null || !user.getPassword().equals(password)) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Invalid credentials");
            return error;
        }

        Map<String, String> response = new HashMap<>();
        response.put("message", "Login successful");
        response.put("email", email);
        return response;
    }

}