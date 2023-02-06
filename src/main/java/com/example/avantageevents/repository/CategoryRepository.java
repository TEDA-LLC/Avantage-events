package com.example.avantageevents.repository;

import com.example.avantageevents.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Malikov Azizjon  *  06.02.2023  *  13:19   *  AvantageEvents
 */

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>, JpaSpecificationExecutor<Category> {

    List<Category> findAllByBot_Id(Long id);

//    Optional<Category> findByNameUzOrNameRuOrNameEn(String nameUz, String nameRu, String nameEn);

}
