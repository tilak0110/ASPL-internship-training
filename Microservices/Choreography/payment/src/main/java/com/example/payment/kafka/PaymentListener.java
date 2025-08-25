package com.example.payment.kafka;

import com.example.payment.entity.Payment;
import com.example.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentListener {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentProducer paymentProducer;

    @KafkaListener(topics = "order-created", groupId = "payment-group")
    public void handleOrderCreated(String orderId) {
        System.out.println("Received OrderCreated event for Order ID: " + orderId);

        // Save payment info
        Payment payment = new Payment();
        payment.setOrderId(Long.parseLong(orderId));
        payment.setStatus("SUCCESS");
        paymentRepository.save(payment);

        // Publish payment-success event
        paymentProducer.sendPaymentSuccessEvent(orderId);
    }
}
