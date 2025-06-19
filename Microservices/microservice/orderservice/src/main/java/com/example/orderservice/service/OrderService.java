package com.example.orderservice.service;

import com.example.orderservice.entities.Order;
import com.example.orderservice.models.User;
import com.example.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class OrderService {

    @Autowired
    private WebClient.Builder userClient;  // Inject WebClient
    private static final Logger logger = Logger.getLogger(OrderService.class.getName());


    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        logger.info("Fetching all orders...");
        List<Order> orders = orderRepository.findAll();

        if (orders.isEmpty()) {
            logger.warning("No orders found in the database.");
        } else {
            logger.info("Fetched " + orders.size() + " orders.");
        }

        return orders;
    }

    public Optional<Order> getOrderById(Long id) {
        logger.info("Fetching order with ID: " + id);
        Optional<Order> order = orderRepository.findById(id);

        if (order.isPresent()) {
            logger.info("Order with ID " + id + " found: " + order.get());
        } else {
            logger.warning("Order with ID " + id + " not found.");
        }

        return order;
    }

    public List<Order> getOrdersByUserId(Long userId) {
        logger.info("Fetching orders for user with ID: " + userId);
        List<Order> orders = orderRepository.findByUserId(userId);

        if (orders.isEmpty()) {
            logger.warning("No orders found for user with ID " + userId);
        } else {
            logger.info("Fetched " + orders.size() + " orders for user with ID " + userId);
        }

        return orders;
    }

    public Order addOrder(Order order) {
        logger.info("Attempting to add a new order: " + order);

        Boolean userExists = userClient

                .build()
                .get()
                .uri("lb://user-service/user-service/users/exists/"+order.getUserId())
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
        ;


        if (Boolean.TRUE.equals(userExists)) {
            logger.info("User with ID " + order.getUserId() + " exists. Proceeding to save order.");
            Order savedOrder = orderRepository.save(order);
            logger.info("Order saved successfully with ID: " + savedOrder.getId());
            return savedOrder;

        } else {
            logger.severe("User with ID " + order.getUserId() + " does not exist. Order cannot be created.");
            throw new RuntimeException("User does not exist");
        }
    }

    public User getUserDetails(Long userId) {
        logger.info("Fetching user details for user with ID: " + userId);
        User userByUserId= userClient
                .build()
                .get()
                .uri("lb://user-service/user-service/users/" + userId)
                .retrieve()
                .bodyToMono(User.class)
                .block();

        if (userByUserId != null) {
            logger.info("Fetched user details: " + userByUserId);
        } else {
            logger.warning("No user details found for user with ID: " + userId);
        }

        return userByUserId;
    }
}
