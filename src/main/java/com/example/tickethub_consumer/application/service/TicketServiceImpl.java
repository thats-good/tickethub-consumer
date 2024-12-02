package com.example.tickethub_consumer.application.service;

import com.example.tickethub_consumer.application.model.Reservation;
import com.example.tickethub_consumer.dataAccess.dao.TicketRepository;
import com.example.tickethub_consumer.dto.CreateTicketMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService{

    private final TicketRepository ticketRepository;

    @Override
    public Reservation createTicket(CreateTicketMessage createTicketMessage) {
        Reservation reservation = new Reservation(ticketRepository);
        try{
            reservation.createTicket(createTicketMessage.userId(), createTicketMessage.performanceId(), createTicketMessage.time(), createTicketMessage.seatNumber());
            return reservation;
        }catch (Exception e){
            e.printStackTrace();
            throw new IllegalArgumentException("Ticket 생성 실패");
        }
    }
}
