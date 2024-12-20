package com.example.tickethub_consumer.application.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MusicalTicket extends Ticket {

    @Column(name = "actor_name", nullable = false)
    private String actorName;
}
