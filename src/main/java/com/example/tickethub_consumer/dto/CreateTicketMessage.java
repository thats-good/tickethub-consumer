package com.example.tickethub_consumer.dto;

import java.time.LocalDateTime;

public record CreateTicketMessage (
        long userId,
        long performanceId,
        LocalDateTime time,
        int seatNumber
){
}
