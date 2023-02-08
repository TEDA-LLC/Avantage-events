package com.example.avantageevents.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Malikov Azizjon  *  08.02.2023  *  17:40   *  AvantageEvents
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Call {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User client;

    @ManyToOne
    private Employee employee;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdTime = LocalDateTime.now();

    private LocalDate nextConnectionDate;

    private String description;

    @OneToMany
    @ToString.Exclude
    private List<ReviewCategory> ReviewCategory;

    private boolean success;

}
