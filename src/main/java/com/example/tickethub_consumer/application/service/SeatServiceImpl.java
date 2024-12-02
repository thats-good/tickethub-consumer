package com.example.tickethub_consumer.application.service;

import com.example.tickethub_consumer.application.model.entity.Seat;
import com.example.tickethub_consumer.application.model.entity.enums.Tag;
import com.example.tickethub_consumer.dataAccess.dao.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SeatServiceImpl implements SeatService {

    private final SeatRepository seatRepository;

    @Override
    public boolean isValidSeatNumber(long performanceId, int seatNumber) {
        Seat seat = seatRepository.findByPerformanceIdAndSeatNumber(performanceId, seatNumber);
        if(seat == null || seat.getTag() != Tag.BEFORE_SALE) {
            return false;
        }
        seat.changeTag(Tag.ON_SALE);
        return true;
    }

    @Override
    public void setSeatTag(long performanceId, int seatNumber, Tag tag) {
        Seat seat = seatRepository.findByPerformanceIdAndSeatNumber(performanceId, seatNumber);
        seat.changeTag(tag);
    }
}
