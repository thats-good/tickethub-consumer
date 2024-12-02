package com.example.tickethub_consumer.dto;

public record CreateTicketMessage (
        long userId,
        String performanceId,
        String time,
        String seatNumber
){
}
