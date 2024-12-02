package com.example.tickethub_consumer.application.model;

import com.example.tickethub_consumer.application.model.entity.Ticket;
import com.example.tickethub_consumer.dataAccess.dao.TicketRepository;

import java.time.LocalDateTime;

public class Reservation {

    private final TicketRepository ticketRepository;
    private Ticket ticket;

    public Reservation(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }
}
