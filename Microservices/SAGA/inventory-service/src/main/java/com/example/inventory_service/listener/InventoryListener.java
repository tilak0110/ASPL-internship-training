package com.example.inventory_service.listener;

import com.example.common_service.dto.InventoryEvent;
import com.example.common_service.dto.OrderEvent;
import com.example.inventory_service.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryListener {

    private final InventoryRepository inventoryRepository;
    private final KafkaTemplate<String, InventoryEvent> kafkaTemplate;

    private static final String INVENTORY_RESERVED_TOPIC = "InventoryReserved";

    @KafkaListener(topics = "ReserveInventory", groupId = "inventory-group")
    public void handleReserveRequest(OrderEvent orderEvent) {
        // In a real app we’d check the actual product, here simulating success
        boolean reserved = true;

        // TODO: If you have productCode in OrderEvent, fetch inventory and check stock
        // reserved = inventoryRepository.findByProductCode(orderEvent.getProductCode())
        //   .filter(item -> item.getQuantityAvailable() > 0)
        //   .isPresent();

        // Send Inventory event back
        InventoryEvent inventoryEvent = new InventoryEvent(orderEvent.getOrderId(), reserved);
        kafkaTemplate.send(INVENTORY_RESERVED_TOPIC, inventoryEvent);
    }
}
