package com.example.pet_shop.service;

import com.example.pet_shop.entity.SattarbekSymbatOrder;
import com.example.pet_shop.entity.SattarbekSymbatProduct;
import com.example.pet_shop.entity.SattarbekSymbatUser;
import com.example.pet_shop.repository.SattarbekSymbatOrderRepository;
import com.example.pet_shop.repository.SattarbekSymbatProductRepository;
import com.example.pet_shop.repository.SattarbekSymbatUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SattarbekSymbatOrderService {

    private final SattarbekSymbatOrderRepository orderRepository;
    private final SattarbekSymbatUserRepository userRepository;
    private final SattarbekSymbatProductRepository productRepository;

    public List<SattarbekSymbatOrder> getAllOrders() {
        return orderRepository.findAll();
    }

    public SattarbekSymbatOrder getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    // ЭТОТ МЕТОД ПРИНИМАЕТ 3 АРГУМЕНТА
    public SattarbekSymbatOrder createOrder(Long userId, Long productId, Integer quantity) {
        SattarbekSymbatUser user = userRepository.findById(userId).orElse(null);
        SattarbekSymbatProduct product = productRepository.findById(productId).orElse(null);

        if (user == null || product == null) {
            return null;
        }

        SattarbekSymbatOrder order = new SattarbekSymbatOrder();
        order.setUser(user);
        order.setProduct(product);
        order.setQuantity(quantity);
        order.setTotalPrice(product.getPrice() * quantity);

        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}