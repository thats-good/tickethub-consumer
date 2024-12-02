package com.example.tickethub_consumer.dataAccess.dao;

import com.example.tickethub_consumer.application.model.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
