package com.example.order_service.controller;

import com.example.order_service.model.Order;
import com.example.order_service.repository.OrderRepository;
import com.example.order_service.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository repo;
    private final OrderService orderService;

    public OrderController(OrderRepository repo,OrderService orderService) {
        this.repo = repo;
        this.orderService = orderService;
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return repo.save(order);
    }
    @PostMapping("/{productId}")
    public String createOrder(@PathVariable Long productId) {
        return orderService.placeOrder(productId);
    }

    @GetMapping
    public List<Order> getOrders() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }
}
