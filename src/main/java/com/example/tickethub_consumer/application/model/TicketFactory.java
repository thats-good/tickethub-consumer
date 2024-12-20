package com.example.tickethub_consumer.application.model;

import com.example.tickethub_consumer.application.model.entity.Performance;
import com.example.tickethub_consumer.application.model.entity.Ticket;
import com.example.tickethub_consumer.application.model.entity.User;
import com.example.tickethub_consumer.dataAccess.dao.TicketRepository;

import java.time.LocalDateTime;

public abstract class TicketFactory {


    private final TicketRepository ticketRepository;
    protected Ticket ticket;

    public TicketFactory(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public abstract void createTicket(User user, Performance performance, LocalDateTime time, int seatNumber);

    public void saveTicket(){
        ticketRepository.save(ticket);
    }
}
