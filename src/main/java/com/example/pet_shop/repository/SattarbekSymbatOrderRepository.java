package com.example.pet_shop.repository;

import com.example.pet_shop.entity.SattarbekSymbatOrder;
import com.example.pet_shop.entity.SattarbekSymbatUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SattarbekSymbatOrderRepository extends JpaRepository<SattarbekSymbatOrder, Long> {

    // Найти заказы конкретного пользователя (с пагинацией)
    Page<SattarbekSymbatOrder> findByUser(SattarbekSymbatUser user, Pageable pageable);
}