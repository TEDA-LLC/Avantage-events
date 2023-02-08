package com.example.avantageevents.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Malikov Azizjon  *  08.02.2023  *  17:37   *  AvantageEvents
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Employee employee;
    private LocalDateTime dateTime = LocalDateTime.now();
    private String beforeUser;
    private boolean view = false;
    @ManyToOne
    private Company company;

}
