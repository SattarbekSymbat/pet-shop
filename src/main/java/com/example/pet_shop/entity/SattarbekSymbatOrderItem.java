package com.example.pet_shop.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "order_items")
@Data
public class SattarbekSymbatOrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private SattarbekSymbatOrder order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private SattarbekSymbatProduct product;

    private Integer quantity;
    private Double priceAtTime;
}