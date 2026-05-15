package com.example.pet_shop.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Data
public class SattarbekSymbatOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private SattarbekSymbatUser user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private SattarbekSymbatProduct product;   // ← ЭТО ПОЛЕ НУЖНО!

    private Integer quantity;
    private Double totalPrice;
    private LocalDateTime orderDate;

    @PrePersist
    protected void onCreate() {
        orderDate = LocalDateTime.now();
    }
}