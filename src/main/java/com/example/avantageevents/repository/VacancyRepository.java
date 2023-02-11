package com.example.avantageevents.repository;

import com.example.avantageevents.model.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Malikov Azizjon  *  06.02.2023  *  13:49   *  AvantageEvents
 */
@Repository
public interface VacancyRepository extends JpaRepository<Vacancy,Long> {

    //    List<Vacancy> findAllByVacancyId(Long id);
    List<Vacancy> findAllByActiveTrueAndDepartment_Id(Long botId);

}
