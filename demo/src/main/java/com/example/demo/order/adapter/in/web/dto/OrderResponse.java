package com.example.demo.order.adapter.in.web.dto;

import com.example.demo.order.domain.Order;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class OrderResponse {
    
    private Long orderId;
    private String description;
    private String orderNumber;
    private String status;
    private LocalDateTime createAt;
    private List<OrderItemResponse> orderItems;
    
    public OrderResponse() {}
    
    public OrderResponse(Long orderId, String description, String orderNumber, String status, 
                        LocalDateTime createAt, List<OrderItemResponse> orderItems) {
        this.orderId = orderId;
        this.description = description;
        this.orderNumber = orderNumber;
        this.status = status;
        this.createAt = createAt;
        this.orderItems = orderItems;
    }
    
    // Getters
    public Long getOrderId() {
        return orderId;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String getOrderNumber() {
        return orderNumber;
    }
    
    public String getStatus() {
        return status;
    }
    
    public LocalDateTime getCreateAt() {
        return createAt;
    }
    
    public List<OrderItemResponse> getOrderItems() {
        return orderItems;
    }
    
    // Convert Domain to DTO
    public static OrderResponse fromDomain(Order order) {
        List<OrderItemResponse> items = null;
        if (order.getOrderItems() != null) {
            items = order.getOrderItems().stream()
                    .map(OrderItemResponse::fromDomain)
                    .collect(Collectors.toList());
        }
        
        return new OrderResponse(
                order.getOrderId(),
                order.getDescription(),
                order.getOrderNumber(),
                order.getStatus(),
                order.getCreateAt(),
                items
        );
    }
}