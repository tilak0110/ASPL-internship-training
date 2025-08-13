package com.example.inventory_service.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "inventory")
@Setter @Getter @AllArgsConstructor @NoArgsConstructor @ToString @Builder
public class InventoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productCode;

    private Integer quantityAvailable;
}
