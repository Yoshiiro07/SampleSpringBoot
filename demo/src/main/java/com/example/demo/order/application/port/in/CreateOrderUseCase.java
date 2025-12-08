package com.example.demo.order.application.port.in;

import com.example.demo.order.domain.Order;

public interface CreateOrderUseCase {
    Order createOrder(Order order);
}
