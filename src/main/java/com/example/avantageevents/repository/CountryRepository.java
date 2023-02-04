package com.example.avantageevents.repository;

import com.example.avantageevents.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Malikov Azizjon  *  04.02.2023  *  19:16   *  AvantageEvents
 */

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
