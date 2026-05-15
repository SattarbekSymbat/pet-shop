package com.example.pet_shop.controller;

import com.example.pet_shop.entity.SattarbekSymbatUser;
import com.example.pet_shop.service.SattarbekSymbatUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class SattarbekSymbatUserController {

    private final SattarbekSymbatUserService userService;

    @GetMapping
    public List<SattarbekSymbatUser> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public SattarbekSymbatUser getUserById(@PathVariable Long id) {
        return userService.getUserById(id).orElse(null);
    }

    @PostMapping
    public SattarbekSymbatUser createUser(
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String name
    ) {
        return userService.createUser(email, password, name);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}