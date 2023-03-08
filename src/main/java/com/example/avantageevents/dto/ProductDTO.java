package com.example.avantageevents.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Malikov Azizjon  *  06.02.2023  *  13:26   *  AvantageEvents
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductDTO {

    private String nameUz, nameRu, nameEn, descriptionUz, descriptionRu, descriptionEn, textUz, textRu, textEn, agreeTextUz, agreeTextEn, agreeTextRu;
    private List<Long> speakersId;
    private Long categoryId;
    private AddressDTO address;
    private MultipartFile attachment;

//    @JsonFormat(pattern="yyyy-MM-ddTHH:mm")
    private String from;
    private String to;
    private Double price;

}
