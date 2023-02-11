package com.example.avantageevents.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author Malikov Azizjon  *  10.02.2023  *  11:51   *  AvantageEvents
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Bot bot;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Site site;
    @OneToMany(mappedBy = "department")
    @ToString.Exclude
    private List<User> clientList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @ToString.Exclude
    private Company company;
    @OneToMany(mappedBy = "department")
    @ToString.Exclude
    private List<Category> categories;

    @OneToMany(mappedBy = "department")
    @ToString.Exclude
    private List<Vacancy> vacancies;

}
