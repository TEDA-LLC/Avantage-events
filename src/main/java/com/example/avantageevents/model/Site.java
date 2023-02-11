package com.example.avantageevents.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Malikov Azizjon  *  10.02.2023  *  12:14   *  AvantageEvents
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
public class Site {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name, link;
    @Column(columnDefinition = "text")
    private String description;

    private LocalDateTime dateTime = LocalDateTime.now();

    @ManyToOne
    @JsonIgnore
    private Company company;

}
