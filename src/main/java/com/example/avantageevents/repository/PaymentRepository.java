package com.example.avantageevents.repository;

import com.example.avantageevents.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Malikov Azizjon  *  08.02.2023  *  15:34   *  AvantageEvents
 */
@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
