package com.example.common_service.dto;

import java.io.Serializable;

public class InventoryEvent implements Serializable {
    private Long orderId;
    private boolean reserved;

    public InventoryEvent() {}

    public InventoryEvent(Long orderId, boolean reserved) {
        this.orderId = orderId;
        this.reserved = reserved;
    }

    public Long getOrderId() {
        return orderId;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public boolean isReserved() {
        return reserved;
    }
    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }
}
