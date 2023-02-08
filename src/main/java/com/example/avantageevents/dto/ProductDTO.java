package com.example.avantageevents.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(pattern="yyyy-MM-ddTHH:mm")
    private LocalDateTime from, to;
    private Double price;

}
