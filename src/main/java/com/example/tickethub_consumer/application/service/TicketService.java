package com.example.tickethub_consumer.application.service;

import com.example.tickethub_consumer.application.model.Reservation;
import com.example.tickethub_consumer.dto.CreateTicketMessage;

public interface TicketService {
    Reservation createTicket(CreateTicketMessage createTicketMessage);
}
