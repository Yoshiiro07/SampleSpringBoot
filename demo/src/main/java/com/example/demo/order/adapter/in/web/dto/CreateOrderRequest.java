package com.example.demo.order.adapter.in.web.dto;

import com.example.demo.order.domain.Order;
import com.example.demo.order.domain.OrderItem;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class CreateOrderRequest {

    private String description;
    private String orderNumber;
    private String status;
    private List<OrderItemRequest> orderItems;

    public CreateOrderRequest() {}
    
    public CreateOrderRequest(String description, String orderNumber, String status, List<OrderItemRequest> orderItems) {
        this.description = description;
        this.orderNumber = orderNumber;
        this.status = status;
        this.orderItems = orderItems;
    }

    // Getters and Setters
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getOrderNumber() {
        return orderNumber;
    }
    
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public List<OrderItemRequest> getOrderItems() {
        return orderItems;
    }
    
    public void setOrderItems(List<OrderItemRequest> orderItems) {
        this.orderItems = orderItems;
    }

    // Convert DTO to Domain
    public Order toDomain() {
        Order order = new Order();
        order.setDescription(this.description);
        order.setOrderNumber(this.orderNumber);
        order.setStatus(this.status);
        order.setCreateAt(LocalDateTime.now());
        
        if (this.orderItems != null) {
            List<OrderItem> items = this.orderItems.stream()
                    .map(OrderItemRequest::toDomain)
                    .collect(Collectors.toList());
            order.setOrderItems(items);
        }
        
        return order;
    }

}
