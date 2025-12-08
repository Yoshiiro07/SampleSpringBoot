package com.example.demo.order.adapter.in.web;


import com.example.demo.order.application.port.in.CreateOrderUseCase;
import com.example.demo.order.application.port.in.GetOrderUseCase;
import com.example.demo.order.application.port.in.ListOrdersUseCase;
import com.example.demo.order.adapter.in.web.dto.CreateOrderRequest;
import com.example.demo.order.adapter.in.web.dto.OrderResponse;
import com.example.demo.order.domain.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/orders")
public class OrderController {
   
    private final CreateOrderUseCase createOrderUseCase
    private final GetOrderUseCase getOrderUseCase;
    private final ListOrdersUseCase listOrdersUseCase;

    public OrderController(CreateOrderUseCase createOrderUseCase,
                           GetOrderUseCase getOrderUseCase,
                           ListOrdersUseCase listOrdersUseCase) {
        this.createOrderUseCase = createOrderUseCase;
        this.getOrderUseCase = getOrderUseCase;
        this.listOrdersUseCase = listOrdersUseCase;
    }

     @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody CreateOrderRequest request) {
        Order order = request.toDomain();
        Order savedOrder = createOrderUseCase.createOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(OrderResponse.fromDomain(savedOrder));
    }

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody CreateOrderRequest request) {
        Order order = request.toDomain();
        Order savedOrder = createOrderUseCase.createOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(OrderResponse.fromDomain(savedOrder));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable Long id) {
        return getOrderUseCase.getOrderById(id)
                .map(order -> ResponseEntity.ok(OrderResponse.fromDomain(order)))
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping
    public ResponseEntity<List<OrderResponse>> getAllOrders() {
        List<OrderResponse> orders = listOrdersUseCase.listAllOrders()
                .stream()
                .map(OrderResponse::fromDomain)
                .collect(Collectors.toList());
        return ResponseEntity.ok(orders);
    }
}
