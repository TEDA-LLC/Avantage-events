package com.example.avantageevents.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Malikov Azizjon  *  04.02.2023  *  19:15   *  AvantageEvents
 */
@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
