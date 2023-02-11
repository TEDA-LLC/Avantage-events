package com.example.avantageevents.repository;

import com.example.avantageevents.model.SiteHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Malikov Azizjon  *  06.02.2023  *  13:43   *  AvantageEvents
 */
@Repository
public interface SiteHistoryRepository extends JpaRepository<SiteHistory, Long> {

    List<SiteHistory> findAllByUser_Department_Id(Long departmentId);

}
