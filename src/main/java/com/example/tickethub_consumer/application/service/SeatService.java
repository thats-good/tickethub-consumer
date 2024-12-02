package com.example.tickethub_consumer.application.service;

import com.example.tickethub_consumer.application.model.entity.enums.Tag;

public interface SeatService {
    boolean isValidSeatNumber(int seatNumber);
    void setSeatTag(int seatNumber, Tag tag);
}
