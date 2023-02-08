package com.example.avantageevents.repository;

import com.example.avantageevents.model.WordHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Malikov Azizjon  *  08.02.2023  *  15:29   *  AvantageEvents
 */
@Repository
public interface WordHistoryRepository extends JpaRepository<WordHistory,Long> {

    List<WordHistory> findAllByUser_Bot_Id(Long botId);

}
