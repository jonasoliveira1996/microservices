package com.owner.hrpayroll.services;

import com.owner.hrpayroll.entites.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(long workerId, int days) {
        return new Payment("Fabio", 200.0, days);
    }
}
