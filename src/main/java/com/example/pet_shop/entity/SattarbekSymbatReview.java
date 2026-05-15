package com.example.pet_shop.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
@Data
public class SattarbekSymbatReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private SattarbekSymbatUser user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private SattarbekSymbatProduct product;

    private Integer rating;
    private String comment;
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}