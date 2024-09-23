package com.meiggsmarket.orderservice.repository;

import com.meiggsmarket.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
