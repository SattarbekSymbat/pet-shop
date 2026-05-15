package com.example.pet_shop.repository;

import com.example.pet_shop.entity.SattarbekSymbatProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SattarbekSymbatProductRepository extends JpaRepository<SattarbekSymbatProduct, Long> {

    Page<SattarbekSymbatProduct> findByNameContainingIgnoreCase(String name, Pageable pageable);

    Page<SattarbekSymbatProduct> findByPriceBetween(Double minPrice, Double maxPrice, Pageable pageable);
}