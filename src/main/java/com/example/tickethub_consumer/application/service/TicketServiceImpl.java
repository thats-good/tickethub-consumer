package com.example.tickethub_consumer.application.service;

import com.example.tickethub_consumer.dataAccess.dao.TicketRepository;
import com.example.tickethub_consumer.dto.CreateTicketMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService{

    private final TicketRepository ticketRepository;

    @Override
    public boolean createTicket(CreateTicketMessage createTicketMessage) {
        return false;
    }
}
