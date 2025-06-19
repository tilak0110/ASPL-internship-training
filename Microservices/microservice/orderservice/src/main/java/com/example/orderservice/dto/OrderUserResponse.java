package com.example.orderservice.dto;


import com.example.orderservice.entities.Order;
import com.example.orderservice.models.User;

import java.util.Optional;

public class OrderUserResponse {
    private Order order;
    private User user;

    public OrderUserResponse() {
    }

    public OrderUserResponse(Order order, User user) {
        this.order = order;
        this.user = user;
    }


    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
