package com.example.demo.order.domain;

public class OrderItem {

    public OrderItem(){}
    
    private Long orderItemId;
    private String productName;
    private Integer quantity;
    private Double price;

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
    
}
