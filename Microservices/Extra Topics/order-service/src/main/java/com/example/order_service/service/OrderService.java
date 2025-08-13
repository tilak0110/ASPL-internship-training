package com.example.order_service.service;


import com.example.order_service.client.InventoryClient;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final InventoryClient inventoryClient;

    public OrderService(InventoryClient inventoryClient) {
        this.inventoryClient = inventoryClient;
    }

    public String placeOrder(Long productId) {
        boolean inStock = inventoryClient.checkStock(productId);

        if (inStock) {
            return " Order placed successfully for product " + productId;
        } else {
            return " Product " + productId + " is out of stock";
        }
    }
}
