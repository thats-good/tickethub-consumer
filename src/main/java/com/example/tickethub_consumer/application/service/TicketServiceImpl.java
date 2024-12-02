package com.example.tickethub_consumer.application.service;

import com.example.tickethub_consumer.application.model.Reservation;
import com.example.tickethub_consumer.application.model.entity.Performance;
import com.example.tickethub_consumer.application.model.entity.User;
import com.example.tickethub_consumer.dataAccess.dao.PerformanceRepository;
import com.example.tickethub_consumer.dataAccess.dao.TicketRepository;
import com.example.tickethub_consumer.dataAccess.dao.UserRepository;
import com.example.tickethub_consumer.dto.CreateTicketMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService{

    private final TicketRepository ticketRepository;
    private final PerformanceRepository performanceRepository;
    private final UserRepository userRepository;

    @Override
    public Reservation createTicket(CreateTicketMessage createTicketMessage) {
        Performance performance = performanceRepository.findByPerformanceId(createTicketMessage.performanceId());
        User user = userRepository.findByUserId(createTicketMessage.userId());
        Reservation reservation = new Reservation(ticketRepository);
        try{
            reservation.createTicket(user, performance, createTicketMessage.time(), createTicketMessage.seatNumber());
            return reservation;
        }catch (Exception e){
            e.printStackTrace();
            throw new IllegalArgumentException("Ticket 생성 실패");
        }
    }
}
