package com.example.payment.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentConsumer {

    @KafkaListener(topics = "order-created", groupId = "payment-group")
    public void consume(String orderId) {
        System.out.println("Processing payment for order: " + orderId);
        // mock payment logic
    }
}
