package com.example.demo.order.adapter.in.web.dto;

import com.example.demo.order.domain.OrderItem;

public class OrderItemResponse {
    
    private Long orderItemId;
    private String productName;
    private Integer quantity;
    private Double price;
    
    public OrderItemResponse() {}
    
    public OrderItemResponse(Long orderItemId, String productName, Integer quantity, Double price) {
        this.orderItemId = orderItemId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
    
    public Long getOrderItemId() {
        return orderItemId;
    }
    
    public String getProductName() {
        return productName;
    }
    
    public Integer getQuantity() {
        return quantity;
    }
    
    public Double getPrice() {
        return price;
    }
    
    public static OrderItemResponse fromDomain(OrderItem item) {
        return new OrderItemResponse(
                item.getOrderItemId(),
                item.getProductName(),
                item.getQuantity(),
                item.getPrice()
        );
    }
}