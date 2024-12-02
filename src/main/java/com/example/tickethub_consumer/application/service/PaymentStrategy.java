package com.example.tickethub_consumer.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PaymentStrategy {

    private final List<Payment> payments;

    public boolean requestPayment(String paymentTag){
        for(Payment payment : payments){
            if(payment.isMatched(paymentTag)){
                return payment.requestPayment();
            }
        }
        return false;
    }

}
