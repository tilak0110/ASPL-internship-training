package com.example.order.kafka;

import com.example.order.entity.Order;
import com.example.order.repository.OrderRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentSuccessListener {

    private final OrderRepository orderRepository;

    public PaymentSuccessListener(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @KafkaListener(topics = "payment-success", groupId = "order-group")
    public void handlePaymentSuccess(String orderId) {
        System.err.println("Received payment-success event for Order ID: " + orderId);
        Order order = orderRepository.findById(Long.parseLong(orderId))
                .orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus("COMPLETED");
        orderRepository.save(order);
    }
}
