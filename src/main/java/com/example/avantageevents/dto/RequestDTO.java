package com.example.avantageevents.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Malikov Azizjon  *  08.02.2023  *  14:17   *  AvantageEvents
 */

@AllArgsConstructor
@Getter
@Setter
@ToString
public class RequestDTO {

    private Long productId;
    private UserDTO user;
    private String aboutProduct, category;
    private boolean agree;

}
