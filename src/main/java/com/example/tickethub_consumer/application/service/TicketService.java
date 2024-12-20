package com.example.tickethub_consumer.application.service;

import com.example.tickethub_consumer.application.model.TicketFactory;
import com.example.tickethub_consumer.dto.CreateTicketMessage;

public interface TicketService {
    TicketFactory createTicket(CreateTicketMessage createTicketMessage);
}
