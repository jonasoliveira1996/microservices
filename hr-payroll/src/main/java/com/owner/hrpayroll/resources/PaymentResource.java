package com.owner.hrpayroll.resources;

import com.owner.hrpayroll.entites.Payment;
import com.owner.hrpayroll.services.PaymentService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentResource {

    @Autowired
    private PaymentService service;

    private final Logger logger = LoggerFactory.getLogger(PaymentResource.class);

    @CircuitBreaker(name = "paymentTotal", fallbackMethod = "getPaymentAlternative")
    @GetMapping("/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(
            @PathVariable Long workerId, @PathVariable Integer days){
        Payment payment = service.getPayment(workerId, days);
        logger.info("worker found");

        return ResponseEntity.ok(payment);
    }
    public ResponseEntity<Payment> getPaymentAlternative(
            @PathVariable Long workerId, @PathVariable Integer days, Throwable e){
        Payment payment = new Payment("Test Circuit Breaker", 5.0, days);
        logger.info("worker not found. Circuit Breaker Open.");

        return ResponseEntity.ok(payment);
    }
}
