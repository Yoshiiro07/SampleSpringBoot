package com.example.demo.order.adapter.in.web.dto;

import com.example.demo.order.domain.OrderItem;

public class OrderItemRequest {
    
    private String productName;
    private Integer quantity;
    private Double price;
    
    public OrderItemRequest() {}
    
    public OrderItemRequest(String productName, Integer quantity, Double price) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
    
    public String getProductName() {
        return productName;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    public Integer getQuantity() {
        return quantity;
    }
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    public Double getPrice() {
        return price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }
    
    public OrderItem toDomain() {
        OrderItem item = new OrderItem();
        item.setProductName(this.productName);
        item.setQuantity(this.quantity);
        item.setPrice(this.price);
        return item;
    }
}