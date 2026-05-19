package com.example.pet_shop.dto;

import lombok.Data;

@Data
public class SattarbekSymbatProductResponse {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer stock;
}