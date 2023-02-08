package com.example.avantageevents.repository;

import com.example.avantageevents.model.Bot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Malikov Azizjon  *  08.02.2023  *  17:43   *  AvantageEvents
 */
@Repository
public interface BotRepository extends JpaRepository<Bot, Long> {
}
