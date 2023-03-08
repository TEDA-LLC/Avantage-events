package com.example.avantageevents.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Malikov Azizjon  *  06.02.2023  *  13:24   *  AvantageEvents
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "text")
    private String nameUz, nameRu, nameEn, descriptionUz, descriptionRu, descriptionEn, textUz, textRu, textEn;

    @ManyToOne
    private Category category;

    @OneToOne(cascade = CascadeType.ALL)
    private Attachment attachment;

    private Double price;

    private Integer minimumTerm;
    //    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDateTime fromDate, toDate;
    @ManyToOne(cascade = CascadeType.ALL)
    private Address address;

    private String executionInterval;
    @Builder.Default
    private boolean active = true;
    @OneToMany
    @ToString.Exclude
    private List<User> speakers;
}
