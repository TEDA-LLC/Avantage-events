package com.example.avantageevents.repository;

import com.example.avantageevents.model.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Malikov Azizjon  *  10.02.2023  *  12:13   *  AvantageEvents
 */
@Repository
public interface SiteRepository extends JpaRepository<Site, Long> {
}
