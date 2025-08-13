package com.example.saga_orchestrator.service;

import com.example.common_service.dto.InventoryEvent;
import com.example.common_service.dto.OrderEvent;
import com.example.common_service.dto.PaymentEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SagaOrchestrator {

    private final KafkaTemplate<String, OrderEvent> orderEventKafkaTemplate;
    private final KafkaTemplate<String, OrderEvent> orderCommandKafkaTemplate;
    private final KafkaTemplate<String, PaymentEvent> paymentEventKafkaTemplate;

    private static final String RESERVE_INVENTORY_TOPIC = "ReserveInventory";
    private static final String PROCESS_PAYMENT_TOPIC = "ProcessPayment";
    private static final String ORDER_UPDATE_TOPIC = "OrderUpdate";

    @KafkaListener(topics = "OrderCreated", groupId = "orchestrator-group")
    public void onOrderCreated(OrderEvent orderEvent) {
        // Start saga by sending command to inventory
        orderCommandKafkaTemplate.send(RESERVE_INVENTORY_TOPIC, orderEvent);
    }

    @KafkaListener(topics = "InventoryReserved", groupId = "orchestrator-group")
    public void onInventoryReserved(InventoryEvent inventoryEvent) {
        if (inventoryEvent.isReserved()) {
            // Reserve successful, ask payment service to process payment
            OrderEvent paymentOrderEvent = new OrderEvent(inventoryEvent.getOrderId(), "INVENTORY_RESERVED", null);
            orderCommandKafkaTemplate.send(PROCESS_PAYMENT_TOPIC, paymentOrderEvent);
        } else {
            // Inventory reservation failed -> fail order
            OrderEvent failEvent = new OrderEvent(inventoryEvent.getOrderId(), "FAILED", null);
            orderEventKafkaTemplate.send(ORDER_UPDATE_TOPIC, failEvent);
        }
    }

    @KafkaListener(topics = "PaymentProcessed", groupId = "orchestrator-group")
    public void onPaymentProcessed(PaymentEvent paymentEvent) {
        if (paymentEvent.isPaid()) {
            OrderEvent successEvent = new OrderEvent(paymentEvent.getOrderId(), "COMPLETED", null);
            orderEventKafkaTemplate.send(ORDER_UPDATE_TOPIC, successEvent);
        } else {
            OrderEvent failEvent = new OrderEvent(paymentEvent.getOrderId(), "FAILED", null);
            orderEventKafkaTemplate.send(ORDER_UPDATE_TOPIC, failEvent);
        }
    }
}
