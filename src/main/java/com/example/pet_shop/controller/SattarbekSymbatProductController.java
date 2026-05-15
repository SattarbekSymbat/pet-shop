package com.example.pet_shop.controller;

import com.example.pet_shop.entity.SattarbekSymbatProduct;
import com.example.pet_shop.service.SattarbekSymbatProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class SattarbekSymbatProductController {

    private final SattarbekSymbatProductService productService;

    // Пагинация + сортировка + фильтрация + поиск
    @GetMapping
    public Page<SattarbekSymbatProduct> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir,
            @RequestParam(required = false) String search,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice
    ) {
        return productService.getAllProducts(page, size, sortBy, sortDir, search, minPrice, maxPrice);
    }

    @GetMapping("/{id}")
    public SattarbekSymbatProduct getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public SattarbekSymbatProduct createProduct(
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam Double price,
            @RequestParam Integer stock
    ) {
        return productService.createProduct(name, description, price, stock);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}