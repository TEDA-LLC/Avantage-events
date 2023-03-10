package com.example.avantageevents.repository;

import com.example.avantageevents.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Malikov Azizjon  *  08.02.2023  *  14:38   *  AvantageEvents
 */

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {

    List<Review> findAllByConfirmationTrueAndUser_Department_Id(Long botId);
    @Query(value = """
            SELECT r.id as id, confirmation, date_time as dataTime, text, user_id as "user"
            FROM review r
                     inner join users u on u.id = r.user_id
            where r.confirmation = true
              and u.department_id = ?1
            ORDER BY date_time DESC
            LIMIT 10""", nativeQuery = true)
    List<Review> findAllByConfirmationTrueForUsers(Long departmentId);
    List<Review> findAllByConfirmationFalseAndUser_Department_Id(Long departmentId);

}
