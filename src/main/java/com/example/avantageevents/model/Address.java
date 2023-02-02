package com.example.avantageevents.model;

import lombok.*;

import javax.persistence.*;

/**
 * @author Malikov Azizjon  *  02.02.2023  *  18:14   *  AvantageEvents
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private District district;

    private String streetHome;

    private Double latitude, longitude;

    public Address(District district, String streetHome) {
        this.district = district;
        this.streetHome = streetHome;
    }

}
