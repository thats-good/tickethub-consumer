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
        boolean isValidSeat = seatService.isValidSeatNumber(createTicketMessage.performanceId(), createTicketMessage.seatNumber());
        if(isValidSeat == false){
            System.out.println("유효하지 않은 좌석");
            return false;
        }

        Reservation reservation = ticketService.createTicket(createTicketMessage);

        boolean isPaid = paymentService.requestPayment(createTicketMessage.payment());
        if(isPaid == false){
            seatService.setSeatTag(createTicketMessage.performanceId(), createTicketMessage.seatNumber(), Tag.BEFORE_SALE);
            return false;
        }

        reservation.saveTicket();
        seatService.setSeatTag(createTicketMessage.performanceId(), createTicketMessage.seatNumber(), Tag.AFTER_SALE);
        return true;
    }
}
