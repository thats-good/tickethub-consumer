package com.example.tickethub_consumer.application.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService{
    @Override
    public boolean requestPayment(String payment) {
        return false;
    }
}
