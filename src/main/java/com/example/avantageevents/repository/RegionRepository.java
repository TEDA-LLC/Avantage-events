package com.example.avantageevents.repository;

import com.example.avantageevents.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Malikov Azizjon  *  04.02.2023  *  19:10   *  AvantageEvents
 */

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {
    List<Region> findAllByCountry_Id(Long countryId);
}
