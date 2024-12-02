package com.example.tickethub_consumer.application.service;

public interface Payment {
    boolean isMatched(String payment);
    boolean requestPayment();
}
