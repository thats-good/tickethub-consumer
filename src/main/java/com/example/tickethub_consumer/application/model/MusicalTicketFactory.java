package com.example.tickethub_consumer.application.model;

import com.example.tickethub_consumer.application.model.entity.MusicalTicket;
import com.example.tickethub_consumer.application.model.entity.Performance;
import com.example.tickethub_consumer.application.model.entity.User;
import com.example.tickethub_consumer.dataAccess.dao.TicketRepository;

import java.time.LocalDateTime;

public class MusicalTicketFactory extends TicketFactory {

    private String actorName;

    public MusicalTicketFactory(TicketRepository ticketRepository, String actorName) {
        super(ticketRepository);
        this.actorName = actorName;
    }

    @Override
    public void createTicket(User user, Performance performance, LocalDateTime time, int seatNumber) {
        super.ticket =  MusicalTicket.builder()
                .user(user)
                .performance(performance)
                .time(time)
                .seatNumber(seatNumber)
                .actorName(actorName)
                .build();
    }
}
