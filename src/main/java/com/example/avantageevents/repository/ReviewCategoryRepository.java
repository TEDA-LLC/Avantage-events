package com.example.avantageevents.repository;

import com.example.avantageevents.model.ReviewCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Malikov Azizjon  *  08.02.2023  *  14:42   *  AvantageEvents
 */

@Repository
public interface ReviewCategoryRepository extends JpaRepository<ReviewCategory,Long> {

    List<ReviewCategory> findAllByActiveTrue();
    Optional<ReviewCategory> findByName(String name);

}
