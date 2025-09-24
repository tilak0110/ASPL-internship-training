package com.example.order.kafka;

import com.example.order.entity.Order;
import com.example.order.repository.OrderRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentEventsConsumer {

    private final OrderRepository orderRepository;

    public PaymentEventsConsumer(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @KafkaListener(topics = "payments", groupId = "order-group")
    public void consumePaymentResult(String message) {
        String[] parts = message.split(":");
        Long orderId = Long.valueOf(parts[0]);
        String paymentStatus = parts[1];

        Optional<Order> orderOpt = orderRepository.findById(orderId);
        if (orderOpt.isPresent()) {
            Order order = orderOpt.get();
            if ("SUCCESS".equals(paymentStatus)) {
                order.setStatus("COMPLETED");
            } else {
                order.setStatus("CANCELLED");
            }
            orderRepository.save(order);
            System.err.println("Order ID " + orderId + " updated to " + order.getStatus());
        }
    }
}
