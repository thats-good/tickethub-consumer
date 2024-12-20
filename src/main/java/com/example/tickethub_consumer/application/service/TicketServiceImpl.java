package com.example.tickethub_consumer.application.service;

import com.example.tickethub_consumer.application.model.PerformanceTicketFactory;
import com.example.tickethub_consumer.application.model.TicketFactory;
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
    public TicketFactory createTicket(CreateTicketMessage createTicketMessage) {
        Performance performance = performanceRepository.findByPerformanceId(createTicketMessage.performanceId());
        User user = userRepository.findByUserId(createTicketMessage.userId());
        TicketFactory ticketFactory = new PerformanceTicketFactory(ticketRepository);
        try{
            ticketFactory.createTicket(user, performance, createTicketMessage.time(), createTicketMessage.seatNumber());
            return ticketFactory;
        }catch (Exception e){
            e.printStackTrace();
            throw new IllegalArgumentException("Ticket 생성 실패");
        }
    }
}
