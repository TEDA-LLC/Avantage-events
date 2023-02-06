package com.example.avantageevents.repository;

import com.example.avantageevents.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Malikov Azizjon  *  06.02.2023  *  13:27   *  AvantageEvents
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByCategoryId(Long id);

    List<Product> findAllByActiveTrueAndCategory_Bot_Id(Long botId);

}
