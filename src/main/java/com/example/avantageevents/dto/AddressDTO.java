package com.example.avantageevents.dto;

import lombok.*;

/**
 * @author Malikov Azizjon  *  04.02.2023  *  17:14   *  AvantageEvents
 */

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class AddressDTO {

    private Long districtId;
    private Double latitude, longitude;
    private String streetHome;

}
