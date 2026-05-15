package com.example.pet_shop.controller;

import com.example.pet_shop.entity.SattarbekSymbatReview;
import com.example.pet_shop.service.SattarbekSymbatReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class SattarbekSymbatReviewController {

    private final SattarbekSymbatReviewService reviewService;

    @GetMapping
    public List<SattarbekSymbatReview> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/{id}")
    public SattarbekSymbatReview getReviewById(@PathVariable Long id) {
        return reviewService.getReviewById(id);
    }

    @PostMapping
    public SattarbekSymbatReview createReview(
            @RequestParam Long userId,
            @RequestParam Long productId,
            @RequestParam Integer rating,
            @RequestParam String comment
    ) {
        return reviewService.createReview(userId, productId, rating, comment);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }
}