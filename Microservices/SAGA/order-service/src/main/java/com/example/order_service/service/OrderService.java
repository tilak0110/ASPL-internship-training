package com.example.order_service.service;

import com.example.common_service.dto.OrderEvent;
import com.example.order_service.entity.Order;
import com.example.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

    private static final String TOPIC = "OrderCreated";

    public Order placeOrder(Order order) {
        // Set order status to pending
        order.setStatus("PENDING");
        order = repository.save(order);

        // Create and send event
        OrderEvent event = new OrderEvent(order.getId(), order.getStatus(), order.getAmount());
        kafkaTemplate.send(TOPIC, event);

        return order;
    }
}
