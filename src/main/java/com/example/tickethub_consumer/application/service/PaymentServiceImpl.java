package com.example.tickethub_consumer.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{

    private final PaymentStrategy paymentStrategy;

    @Override
    public boolean requestPayment(String payment) {
        return paymentStrategy.requestPayment(payment);
    }
}
