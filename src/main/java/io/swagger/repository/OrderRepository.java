package io.swagger.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.swagger.model.Order;

public interface OrderRepository extends JpaRepository<Order, String> {
    List<Order> findByUserId(String userId);
}