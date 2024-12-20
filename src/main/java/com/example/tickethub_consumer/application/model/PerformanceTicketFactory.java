package com.example.tickethub_consumer.application.model;

import com.example.tickethub_consumer.application.model.entity.Performance;
import com.example.tickethub_consumer.application.model.entity.PerformanceTicket;
import com.example.tickethub_consumer.application.model.entity.User;
import com.example.tickethub_consumer.dataAccess.dao.TicketRepository;

import java.time.LocalDateTime;

public class PerformanceTicketFactory extends TicketFactory {

    public PerformanceTicketFactory(TicketRepository ticketRepository) {
        super(ticketRepository);
    }

    @Override
    public void createTicket(User user, Performance performance, LocalDateTime time, int seatNumber) {
        super.ticket = PerformanceTicket.builder()
                .user(user)
                .performance(performance)
                .time(time)
                .seatNumber(seatNumber)
                .build();
    }
}
