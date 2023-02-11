package com.example.avantageevents.repository;

import com.example.avantageevents.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Malikov Azizjon  *  10.02.2023  *  12:11   *  AvantageEvents
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
