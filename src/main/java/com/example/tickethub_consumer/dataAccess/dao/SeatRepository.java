package com.example.tickethub_consumer.dataAccess.dao;

import com.example.tickethub_consumer.application.model.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    @Query("SELECT s FROM Seat s " +
            "WHERE performance_id = :performanceId AND seatNumber = :seatNumber")
    Seat findByPerformanceIdAndSeatNumber(long performanceId, int seatNumber);
}
