package io.swagger.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.swagger.model.Order;
import io.swagger.repository.OrderRepository;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Order getOrderById(String id){
        return orderRepository.findById(id).orElse(null);
    }

    public List<Order> getOrdersByUser(String id){
        return orderRepository.findByUserId(id);
    }

    public Order createOrder(Order order){
        return orderRepository.save(order);
    }

    public void deleteOrder(String id){
        if(!orderRepository.existsById(id)){
            throw new RuntimeException("Order not found");
        }
        orderRepository.deleteById(id);
    }
    
}
