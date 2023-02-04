package com.example.avantageevents.repository;

import com.example.avantageevents.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Malikov Azizjon  *  02.02.2023  *  18:15   *  AvantageEvents
 */

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
