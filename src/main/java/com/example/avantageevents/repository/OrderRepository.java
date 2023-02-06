package com.example.avantageevents.repository;

import com.example.avantageevents.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Malikov Azizjon  *  06.02.2023  *  13:23   *  AvantageEvents
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Page<Order> findAllByActiveTrueAndReadyTrue(Pageable pageable);
    Page<Order> findAllByActiveTrueAndReadyFalse(Pageable pageable);
    Page<Order> findAllByActiveFalseAndReadyTrue(Pageable pageable);
    Page<Order> findAllByActiveFalseAndReadyFalse(Pageable pageable);

}
