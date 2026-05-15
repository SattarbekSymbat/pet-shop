package com.example.pet_shop.repository;

import com.example.pet_shop.entity.SattarbekSymbatUser;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SattarbekSymbatUserRepository extends JpaRepository<SattarbekSymbatUser, Long> {

    Optional<SattarbekSymbatUser> findByEmail(String email);
}