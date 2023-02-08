package com.example.avantageevents.repository;

import com.example.avantageevents.model.Product;
import com.example.avantageevents.model.Request;
import com.example.avantageevents.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Malikov Azizjon  *  08.02.2023  *  14:32   *  AvantageEvents
 */
@Repository
public interface ReqestRepository extends JpaRepository<Request,Long> {

    List<Request> findAllByUserAndProduct_Category_Bot_Id(User user, Long botId, Sort sort);
    List<Request> findAllByUser(User user);
    List<Request> findAllByProduct_Category_Bot_Id(Long botId);
    List<Request> findAllByProductAndUser_Email(Product product, String email);
    List<Request> findAllByProductAndUser_Phone(Product product, String phone);
    List<Request> findAllByProductAndUser(Product product, User user);
    Page<Request> findAllByView(boolean view, Pageable pageable);

}
