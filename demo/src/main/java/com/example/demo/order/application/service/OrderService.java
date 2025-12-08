package com.example.demo.order.application.service;

import com.example.demo.order.application.port.in.CreateOrderUseCase;
import com.example.demo.order.application.port.in.GetOrderUseCase;
import com.example.demo.order.application.port.in.ListOrdersUseCase;
import com.example.demo.order.application.port.out.OrderRepository;

import com.example.demo.order.domain.Order;

import java.util.List;
import java.util.Optional;

public class OrderService implements CreateOrderUseCase, GetOrderUseCase, ListOrdersUseCase{
    
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Optional<Order> getOrderById(Long orderId) {
        return orderRepository.findById(orderId);
    }

    @Override
    public List<Order> listAllOrders() {
        return orderRepository.findAll();
    }
}
