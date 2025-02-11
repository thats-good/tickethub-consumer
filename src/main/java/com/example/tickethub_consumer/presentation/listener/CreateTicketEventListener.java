package com.example.tickethub_consumer.presentation.listener;

import com.example.tickethub_consumer.application.service.TicketSystem;
import com.example.tickethub_consumer.dto.CreateTicketMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateTicketEventListener {

    private final TicketSystem ticketSystem;

    @KafkaListener(topics = "#{@kafkaConfig.getReservationMessageTopic()}", groupId = "#{@kafkaConfig.getReservationMessageGroup()}")
    public void listen(String message, Acknowledgment acknowledgment, ConsumerRecord<String, String> record) {
        long offset = record.offset();

        CreateTicketMessage createTicketMessage = parseCreateTicketMessage(message);
        System.out.println("Received message: " + message + " offset: " + offset + " partition: " + Integer.toString(record.partition()));

        // 메시지 처리 로직
        try {
            boolean isProcessComplete = ticketSystem.processMessage(createTicketMessage);
            if (isProcessComplete) {
                acknowledgment.acknowledge(); // 성공적으로 메시지를 처리한 후 수동으로 커밋
                System.out.println("Message was committed");
            } else {
                System.out.println("Message was not committed");
            }
        } catch (Exception e) {
            System.err.println("Error processing message: " + message);
            // 예외 처리 로직, 필요한 경우 재처리 로직 구현
        }
    }

    private CreateTicketMessage parseCreateTicketMessage(String message) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(message, CreateTicketMessage.class);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid message format: " + message, e);
        }
    }

}
