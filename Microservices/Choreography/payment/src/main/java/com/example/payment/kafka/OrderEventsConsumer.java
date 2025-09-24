package com.example.payment.kafka;

import com.example.payment.entity.Payment;
import com.example.payment.repository.PaymentRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.kafka.core.KafkaTemplate;

@Service
public class OrderEventsConsumer {

    private final PaymentRepository paymentRepository;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public OrderEventsConsumer(PaymentRepository paymentRepository, KafkaTemplate<String, String> kafkaTemplate) {
        this.paymentRepository = paymentRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = "orders", groupId = "payment-group")
    public void consumeOrderCreated(String orderId) {
        System.out.println("Received OrderCreated event for Order ID: " + orderId);

        // Simulate payment logic
        boolean paymentSuccess = Math.random() > 0.3; // 70% success rate

        Payment payment = new Payment();
        payment.setOrderId(Long.valueOf(orderId));
        payment.setStatus(paymentSuccess ? "SUCCESS" : "FAILED");
        paymentRepository.save(payment);

        // Publish payment result
        if (paymentSuccess) {
            kafkaTemplate.send("payments", orderId + ":SUCCESS");
            System.err.println("Payment SUCCESS for Order ID: " + orderId);
        } else {
            kafkaTemplate.send("payments", orderId + ":FAILED");
            System.err.println("Payment FAILED for Order ID: " + orderId);
        }
    }
}
