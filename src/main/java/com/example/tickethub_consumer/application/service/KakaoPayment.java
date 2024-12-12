package com.example.tickethub_consumer.application.service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KakaoPayment implements Payment {

    private static final String paymentTag = "KAKAO_PAY";

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
