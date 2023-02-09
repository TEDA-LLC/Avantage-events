package com.example.avantageevents.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author Malikov Azizjon  *  09.02.2023  *  21:55   *  AvantageEvents
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Avatar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    @ToString.Exclude
    @JsonIgnore
    private List<Attachment> photos;
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private User user;
    private String personal;
    private String  aboutWork;
    private String hobby;

}
