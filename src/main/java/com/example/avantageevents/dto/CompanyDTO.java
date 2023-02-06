package com.example.avantageevents.dto;

import com.example.avantageevents.model.BankInfo;
import com.example.avantageevents.model.enums.ActiveTypes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.A;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Malikov Azizjon  *  06.02.2023  *  13:11   *  AvantageEvents
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDTO {

    private Long memberOrganizationId;
    private String name, stirNumber;
    private ActiveTypes activeType;
    private BankInfo bankInfo;
    private MultipartFile attachment;

    private Long directorId;

    private AddressDTO addressDTO;

}
