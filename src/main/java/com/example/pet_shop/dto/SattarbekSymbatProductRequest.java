package com.example.pet_shop.dto;

import lombok.Data;

@Data
public class SattarbekSymbatProductRequest {
    private String name;
    private String description;
    private Double price;
    private Integer stock;
}