package com.example.tickethub_consumer.dataAccess.dao;

import com.example.tickethub_consumer.application.model.entity.Performance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformanceRepository extends JpaRepository<Performance, Long> {
    Performance findByPerformanceId(long performanceId);
}
