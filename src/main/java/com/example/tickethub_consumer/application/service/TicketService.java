package com.example.tickethub_consumer.application.service;

import com.example.tickethub_consumer.dto.CreateTicketMessage;

public interface TicketService {
    boolean createTicket(CreateTicketMessage createTicketMessage);
}
