package com.example.pet_shop.controller;

import com.example.pet_shop.entity.SattarbekSymbatOrder;
import com.example.pet_shop.service.SattarbekSymbatOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class SattarbekSymbatOrderController {

    private final SattarbekSymbatOrderService orderService;

    @GetMapping
    public List<SattarbekSymbatOrder> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public SattarbekSymbatOrder getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping
    public SattarbekSymbatOrder createOrder(
            @RequestParam Long userId,
            @RequestParam Long productId,
            @RequestParam Integer quantity
    ) {
        return orderService.createOrder(userId, productId, quantity);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}