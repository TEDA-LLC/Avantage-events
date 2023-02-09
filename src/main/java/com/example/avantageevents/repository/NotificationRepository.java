package com.example.avantageevents.repository;

import com.example.avantageevents.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Malikov Azizjon  *  08.02.2023  *  17:39   *  AvantageEvents
 */
@Repository
public interface NotificationRepository extends JpaRepository<Notification,Long> {
}
