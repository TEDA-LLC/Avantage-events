package com.example.avantageevents.model;

import com.example.avantageevents.model.enums.ActiveTypes;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Malikov Azizjon  *  04.02.2023  *  19:14   *  AvantageEvents
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@ToString
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String shortName;

    public Country(String name, String shortName) {
        this.name = name;
        this.shortName = shortName;
    }

}
