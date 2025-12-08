package com.example.demo.order.domain;

import java.time.LocalDateTime;
import java.util.List;

public class Order {

    public Order(){}
    
    private Long orderId;
    private String description;
    private String orderNumber;
    private String status;
    private LocalDateTime createAt;
    private List<OrderItem> orderItems;

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

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }


}
