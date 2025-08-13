package com.example.payment_service.listner;

import com.example.common_service.dto.OrderEvent;
import com.example.common_service.dto.PaymentEvent;
import com.example.payment_service.entity.Payment;
import com.example.payment_service.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentListener {

    private final PaymentRepository paymentRepository;
    private final KafkaTemplate<String, PaymentEvent> kafkaTemplate;

    private static final String PAYMENT_PROCESSED_TOPIC = "PaymentProcessed";

    @KafkaListener(topics = "ProcessPayment", groupId = "payment-group")
    public void handleProcessPayment(OrderEvent orderEvent) {
        // Simulate successful payment, or implement logic if you want to trigger failure
        boolean paid = true;

        // Optionally persist payment record
        Payment payment = Payment.builder()
                .orderId(orderEvent.getOrderId())
                .amount(orderEvent.getAmount())
                .status(paid ? "PAID" : "FAILED")
                .build();
        paymentRepository.save(payment);

        // Send payment processed event
        PaymentEvent paymentEvent = new PaymentEvent(orderEvent.getOrderId(), paid);
        kafkaTemplate.send(PAYMENT_PROCESSED_TOPIC, paymentEvent);
    }
}
