package com.example.payment_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "payments")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long orderId;
    private Double amount;
    private String status; // e.g. "PAID", "FAILED"
}
