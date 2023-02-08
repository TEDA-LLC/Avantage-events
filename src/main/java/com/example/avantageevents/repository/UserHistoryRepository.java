package com.example.avantageevents.repository;

import com.example.avantageevents.model.UserHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Malikov Azizjon  *  08.02.2023  *  14:55   *  AvantageEvents
 */

@Repository
public interface UserHistoryRepository extends JpaRepository<UserHistory,Long> {

    @Query(value = "select count(id) as amount from user_history where product_id =:id",nativeQuery = true)
    long getAmountByProduct(@Param("id") long id);
    List<UserHistory> findAllByUser_Bot_Id(Long botId);

}
