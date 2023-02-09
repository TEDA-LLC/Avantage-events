package com.example.avantageevents.repository;

import com.example.avantageevents.model.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Malikov Azizjon  *  09.02.2023  *  21:57   *  AvantageEvents
 */
@Repository
public interface AvatarRepository extends JpaRepository<Avatar, Long> {
}
