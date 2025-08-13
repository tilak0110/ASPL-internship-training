package com.example.common_service.dto;

import java.io.Serializable;

public class OrderEvent implements Serializable {
    private Long orderId;
    private String status;
    private Double amount;

    public OrderEvent() {}

    public OrderEvent(Long orderId, String status, Double amount) {
        this.orderId = orderId;
        this.status = status;
        this.amount = amount;
    }

    public Long getOrderId() {
        return orderId;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }
}