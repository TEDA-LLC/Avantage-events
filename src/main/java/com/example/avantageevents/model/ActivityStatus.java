package com.example.avantageevents.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Malikov Azizjon  *  04.02.2023  *  19:17   *  AvantageEvents
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class ActivityStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private ActivityStatus firstCase;
    private ActivityStatus secondCase;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime period = LocalDateTime.now();
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private User client;

}
