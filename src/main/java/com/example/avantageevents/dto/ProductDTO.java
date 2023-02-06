package com.example.avantageevents.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

/**
 * @author Malikov Azizjon  *  06.02.2023  *  13:26   *  AvantageEvents
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductDTO {

    private String nameUz, nameRu, nameEn, descriptionUz, descriptionRu, descriptionEn;

    private Long categoryId;
    private AddressDTO address;
    private MultipartFile attachment;
    private LocalDateTime from, to;
    private Double price;

}
