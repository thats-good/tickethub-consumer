package com.example.tickethub_consumer.application.service;

import com.example.tickethub_consumer.application.model.entity.enums.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SeatServiceImpl implements SeatService {

    @Override
    public boolean isValidSeatNumber(int seatNumber) {
        return false;
    }

    @Override
    public void setSeatTag(int seatNumber, Tag tag) {

    }
}
