package com.example.tickethub_consumer.application.service;

import com.example.tickethub_consumer.application.model.Reservation;
import com.example.tickethub_consumer.application.model.entity.enums.Tag;
import com.example.tickethub_consumer.dto.CreateTicketMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketSystemImpl implements TicketSystem{

    private final TicketService ticketService;
    private final PaymentService paymentService;
    private final SeatService seatService;


    @Override
    public boolean processMessage(CreateTicketMessage createTicketMessage) {
        if(seatService.isValidSeatNumber(createTicketMessage.seatNumber()) == false){
            seatService.setSeatTag(createTicketMessage.seatNumber(), Tag.ON_SALE);
            return false;
        }
        Reservation reservation = ticketService.createTicket(createTicketMessage);
        if(paymentService.requestPayment(createTicketMessage.payment()) == false){
            seatService.setSeatTag(createTicketMessage.seatNumber(), Tag.ON_SALE);
            return false;
        }
        reservation.saveTicket();
        seatService.setSeatTag(createTicketMessage.seatNumber(), Tag.AFTER_SALE);
        return true;
    }
}
