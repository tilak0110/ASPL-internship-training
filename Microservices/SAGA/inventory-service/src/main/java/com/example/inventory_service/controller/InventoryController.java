package com.example.inventory_service.controller;

import com.example.inventory_service.entity.InventoryItem;
import com.example.inventory_service.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryRepository repository;

    @PostMapping
    public ResponseEntity<InventoryItem> addItem(@RequestBody InventoryItem item) {
        return ResponseEntity.ok(repository.save(item));
    }

    @GetMapping
    public List<InventoryItem> getAll() {
        return repository.findAll();
    }
}
