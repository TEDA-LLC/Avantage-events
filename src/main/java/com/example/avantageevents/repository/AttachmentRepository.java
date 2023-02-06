package com.example.avantageevents.repository;

import com.example.avantageevents.model.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Malikov Azizjon  *  06.02.2023  *  12:54   *  AvantageEvents
 */

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
}
