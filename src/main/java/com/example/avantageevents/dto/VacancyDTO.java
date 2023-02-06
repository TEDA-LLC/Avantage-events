package com.example.avantageevents.dto;

import lombok.*;

/**
 * @author Malikov Azizjon  *  06.02.2023  *  13:50   *  AvantageEvents
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class VacancyDTO {

    private String name, description;
    private boolean active = true;

}
