package com.example.demo.order.application.port.in;

import com.example.demo.order.domain.Order;
import java.util.List;

public interface ListOrdersUseCase {
    List<Order> listAllOrders();
}
