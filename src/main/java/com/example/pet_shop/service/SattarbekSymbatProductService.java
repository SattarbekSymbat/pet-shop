package com.example.pet_shop.service;

import com.example.pet_shop.dto.SattarbekSymbatProductResponse;
import com.example.pet_shop.entity.SattarbekSymbatProduct;
import com.example.pet_shop.repository.SattarbekSymbatProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SattarbekSymbatProductService {

    private final SattarbekSymbatProductRepository productRepository;

    // Пагинация + сортировка + фильтрация + поиск
    public Page<SattarbekSymbatProduct> getAllProducts(int page, int size, String sortBy, String sortDir,
                                                       String search, Double minPrice, Double maxPrice) {
        Sort sort = sortDir.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page, size, sort);

        if (search != null && !search.isEmpty()) {
            return productRepository.findByNameContainingIgnoreCase(search, pageable);
        }

        if (minPrice != null || maxPrice != null) {
            if (minPrice == null) minPrice = 0.0;
            if (maxPrice == null) maxPrice = Double.MAX_VALUE;
            return productRepository.findByPriceBetween(minPrice, maxPrice, pageable);
        }

        return productRepository.findAll(pageable);
    }

    public SattarbekSymbatProduct getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public SattarbekSymbatProduct createProduct(String name, String description, Double price, Integer stock) {
        SattarbekSymbatProduct product = new SattarbekSymbatProduct();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setStock(stock);
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    // ==================== МАППИНГ (ENTITY → DTO) ====================
    public SattarbekSymbatProductResponse toResponse(SattarbekSymbatProduct product) {
        SattarbekSymbatProductResponse response = new SattarbekSymbatProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setDescription(product.getDescription());
        response.setPrice(product.getPrice());
        response.setStock(product.getStock());
        return response;
    }
}