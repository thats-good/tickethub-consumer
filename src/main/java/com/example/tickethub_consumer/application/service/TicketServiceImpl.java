package com.example.tickethub_consumer.application.service;

import com.example.tickethub_consumer.dto.CreateTicketMessage;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService{
    @Override
    public boolean processMessage(CreateTicketMessage createTicketMessage) {
        return false;
    }
}
