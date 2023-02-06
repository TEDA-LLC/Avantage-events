package com.example.avantageevents.service;

import com.example.avantageevents.dto.ApiResponse;
import com.example.avantageevents.model.Country;
import com.example.avantageevents.model.District;
import com.example.avantageevents.model.Region;
import com.example.avantageevents.repository.CountryRepository;
import com.example.avantageevents.repository.DistrictRepository;
import com.example.avantageevents.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Malikov Azizjon  *  06.02.2023  *  13:04   *  AvantageEvents
 */

@Service
@RequiredArgsConstructor
public class AddressService {

    private final DistrictRepository districtRepository;
    private final RegionRepository regionRepository;
    private final CountryRepository countryRepository;

    public ApiResponse<List<District>> getAllDistricts(Long regionId) {
        List<District> districts;
        if (regionId != null) {
            districts = districtRepository.findAllByRegion_Id(regionId);
        } else {
            districts = districtRepository.findAll();
        }
        return ApiResponse.<List<District>>builder().
                message("Here").
                status(200).
                success(true).
                data(districts).
                build();
    }

    public ApiResponse<List<Region>> getAllRegions(Long countryId) {
        List<Region> regions;
        if (countryId != null) {
            regions = regionRepository.findAllByCountry_Id(countryId);
        } else {
            regions = regionRepository.findAll();
        }
        return ApiResponse.<List<Region>>builder().
                message("Here").
                status(200).
                success(true).
                data(regions).
                build();
    }

    public ApiResponse<List<Country>> getAllCountry() {
        return ApiResponse.<List<Country>>builder().
                message("Here").
                status(200).
                success(true).
                data(countryRepository.findAll()).
                build();
    }

}
