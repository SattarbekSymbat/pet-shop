package com.example.pet_shop.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "categories")
@Data
public class SattarbekSymbatCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;  // DOG, CAT, BIRD, RODENT, FISH
    private String description;
}