package com.example.pet_shop.service;

import com.example.pet_shop.entity.SattarbekSymbatReview;
import com.example.pet_shop.entity.SattarbekSymbatUser;
import com.example.pet_shop.entity.SattarbekSymbatProduct;
import com.example.pet_shop.repository.SattarbekSymbatReviewRepository;
import com.example.pet_shop.repository.SattarbekSymbatUserRepository;
import com.example.pet_shop.repository.SattarbekSymbatProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SattarbekSymbatReviewService {

    private final SattarbekSymbatReviewRepository reviewRepository;
    private final SattarbekSymbatUserRepository userRepository;
    private final SattarbekSymbatProductRepository productRepository;

    public List<SattarbekSymbatReview> getAllReviews() {
        return reviewRepository.findAll();
    }

    public SattarbekSymbatReview getReviewById(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    public SattarbekSymbatReview createReview(Long userId, Long productId, Integer rating, String comment) {
        SattarbekSymbatUser user = userRepository.findById(userId).orElse(null);
        SattarbekSymbatProduct product = productRepository.findById(productId).orElse(null);

        if (user == null || product == null) {
            return null;
        }

        SattarbekSymbatReview review = new SattarbekSymbatReview();
        review.setUser(user);
        review.setProduct(product);
        review.setRating(rating);
        review.setComment(comment);

        return reviewRepository.save(review);
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}