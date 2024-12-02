package com.example.tickethub_consumer.application.service;

import com.example.tickethub_consumer.application.model.entity.enums.Tag;

public interface SeatService {
    boolean isValidSeatNumber(long performanceId, int seatNumber);
    void setSeatTag(long performanceId, int seatNumber, Tag tag);
}
