package com.example.order_service.client;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.time.Duration;

@Service
public class InventoryClient {
    private final WebClient webClient;


    public InventoryClient(@LoadBalanced WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://inventory-service").build();
    }

    public boolean checkStock(Long productId) {
        try {
            return Boolean.TRUE.equals(webClient.get()
                    .uri("/inventory/check/{id}", productId)
                    .retrieve()
                    .bodyToMono(Boolean.class)
                    .timeout(Duration.ofSeconds(3)) // Add timeout
                    .block());
        } catch (WebClientResponseException e) {

            if (e.getStatusCode().is5xxServerError()) {

            }
            return false;
        } catch (Exception e) {

            return false;
        }
    }
}