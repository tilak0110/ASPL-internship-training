package com.example.payment_service.controller;

import com.example.payment_service.model.Payment;
import com.example.payment_service.repository.PaymentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentRepository repo;

    public PaymentController(PaymentRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public Payment makePayment(@RequestBody Payment payment) {
        return repo.save(payment);
    }

    @GetMapping
    public List<Payment> getPayments() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Payment getPayment(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }
}
