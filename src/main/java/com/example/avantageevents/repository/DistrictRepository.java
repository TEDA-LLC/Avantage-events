package com.example.avantageevents.repository;

import com.example.avantageevents.model.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Malikov Azizjon  *  04.02.2023  *  17:20   *  AvantageEvents
 */

@Repository
public interface DistrictRepository extends JpaRepository<District, Long> {
    List<District> findAllByRegion_Id(Long regionId);
}
