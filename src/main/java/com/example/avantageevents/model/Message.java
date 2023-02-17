package com.example.avantageevents.model;

import com.example.avantageevents.model.enums.MessageType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Builder
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    @ManyToOne
    private Bot bot;
    @ManyToOne
    private User user;
    @ManyToOne
    private Request request;
    @Enumerated(EnumType.STRING)
    private MessageType messageType;
    @Builder.Default
    private LocalDateTime sendTime = LocalDateTime.now();
    private LocalDateTime acceptTime;
    private boolean accept;
}
