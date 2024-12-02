package com.example.tickethub_consumer.application.service;

import com.example.tickethub_consumer.application.model.entity.enums.Tag;
import com.example.tickethub_consumer.dataAccess.dao.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SeatServiceImpl implements SeatService {

    private final SeatRepository seatRepository;

    @Override
    public boolean isValidSeatNumber(int seatNumber) {
        return false;
    }

    @Override
    public void setSeatTag(int seatNumber, Tag tag) {

    }
}
