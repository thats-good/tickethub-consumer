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

    public void createTicket(long userId, int performanceId, LocalDateTime time, int seatNumber) {
        ticket = Ticket.builder()
                .performanceId(performanceId)
                .time(time)
                .seatNumber(seatNumber)
                .build();
    }

    public void saveTicket(){
        ticketRepository.save(ticket);
    }
}
