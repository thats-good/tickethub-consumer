package com.example.tickethub_consumer.application.service;

import org.springframework.stereotype.Component;

@Component
public class CardPayment implements Payment{

    private static final String paymentTag = "CARD";

    @Override
    public boolean isMatched(String payment) {
        return paymentTag.equals(payment);
    }

    @Override
    public boolean requestPayment() {
        //TODO : 계산 로직 수행
        return true;
    }
}
