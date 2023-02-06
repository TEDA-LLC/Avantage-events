package com.example.avantageevents.repository;

import com.example.avantageevents.model.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Malikov Azizjon  *  04.02.2023  *  19:15   *  AvantageEvents
 */
@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    Page<Company> findAllByActive(boolean active, Pageable pageable);

    List<Company> findAllByDirector(Employee employee);

}
