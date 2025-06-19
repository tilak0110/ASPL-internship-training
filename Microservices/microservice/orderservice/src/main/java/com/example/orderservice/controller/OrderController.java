package com.example.orderservice.controller;

import com.example.orderservice.dto.OrderUserResponse;
import com.example.orderservice.entities.Order;
import com.example.orderservice.models.User;
import com.example.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;


@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;
    private static final Logger logger = Logger.getLogger(OrderController.class.getName());
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        logger.info("Fetching all orders...");
        List<Order> orders = orderService.getAllOrders();
        if (orders.isEmpty()) {
            logger.warning("No orders found.");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        logger.info("Fetched " + orders.size() + " orders.");
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderUserResponse> getOrderById(@PathVariable Long id) {
        logger.info("Fetching order with ID: " + id);
        Optional<Order> order = orderService.getOrderById(id);

        if (order.isPresent()) {

            logger.info("Order found: " + order.get());
            User userDetails = orderService.getUserDetails(order.get().getUserId());
            logger.info("Fetched user details for userId " + order.get().getUserId() + ": " + userDetails);

            return new ResponseEntity<>(new OrderUserResponse(order.get(),userDetails), HttpStatus.OK);
        }
        logger.warning("Order with ID " + id + " not found.");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> addOrder(@RequestBody Order order) {
        logger.info("Attempting to add new order: " + order);
        try {
            Order savedOrder = orderService.addOrder(order);
            logger.info("Order saved successfully with ID: " + savedOrder.getId());
            return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            logger.severe("Error adding order: User does not exist.");
            logger.log(Level.SEVERE, "Exception occurred: ", e);
            return new ResponseEntity<>("User does not exist", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
