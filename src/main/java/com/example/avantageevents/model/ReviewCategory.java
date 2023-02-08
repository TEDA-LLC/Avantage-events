package com.example.avantageevents.model;

import lombok.*;

import javax.persistence.*;

/**
 * @author Malikov Azizjon  *  08.02.2023  *  14:42   *  AvantageEvents
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
public class ReviewCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private boolean active = true;

}
