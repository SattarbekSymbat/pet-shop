package com.example.pet_shop.service;

import com.example.pet_shop.entity.SattarbekSymbatUser;
import com.example.pet_shop.repository.SattarbekSymbatUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SattarbekSymbatUserService {

    private final SattarbekSymbatUserRepository userRepository;

    public List<SattarbekSymbatUser> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<SattarbekSymbatUser> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public SattarbekSymbatUser createUser(String email, String password, String name) {
        SattarbekSymbatUser user = new SattarbekSymbatUser();
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public Optional<SattarbekSymbatUser> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}