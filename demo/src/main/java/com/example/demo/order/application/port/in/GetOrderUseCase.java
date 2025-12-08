package com.example.demo.order.application.port.in;

import com.example.demo.order.domain.Order;
import java.util.Optional;

public interface GetOrderUseCase {
    Optional<Order> getOrderById(Long orderId);
}
