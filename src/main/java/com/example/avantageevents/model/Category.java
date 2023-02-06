package com.example.avantageevents.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

/**
 * @author Malikov Azizjon  *  06.02.2023  *  13:18   *  AvantageEvents
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //    @Column(unique = true)
    private String nameUz;

    //    @Column(unique = true)
    private String nameRu;

    //    @Column(unique = true)
    private String nameEn;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Bot bot;

}
