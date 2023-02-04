package com.example.avantageevents.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

/**
 * @author Malikov Azizjon  *  04.02.2023  *  21:41   *  AvantageEvents
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ApiResponse <T>{

    private String message;
    private boolean success;
    @JsonIgnore
    private int status;
    private T data;

}
