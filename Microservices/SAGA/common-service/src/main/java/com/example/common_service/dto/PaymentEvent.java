package com.example.common_service.dto;

import java.io.Serializable;

public class PaymentEvent implements Serializable {
    private Long orderId;
    private boolean paid;

    public PaymentEvent() {}

    public PaymentEvent(Long orderId, boolean paid) {
        this.orderId = orderId;
        this.paid = paid;
    }

    public Long getOrderId() {
        return orderId;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public boolean isPaid() {
        return paid;
    }
    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
