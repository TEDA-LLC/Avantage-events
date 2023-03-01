package com.example.avantageevents.repository;

import com.example.avantageevents.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Malikov Azizjon  *  04.02.2023  *  21:45   *  AvantageEvents
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username);
    Optional<User> findByDepartment_IdAndQrcode(Long departmentId, UUID qrcode);
    //    Optional<User> findByPhoneAndDepartment_Id(String phone, Long departmentId);
    Page<User> findAllByDepartment_Id(Long departmentId, Pageable pageable);
    Optional<User> findByPhoneAndDepartment_Id(String phone, Long departmentId);
    Optional<User> findByEmailAndDepartment_Id(String email, Long departmentId);

    Page<User> findAllByActiveTrue(Pageable pageable);
    List<User> findAllByDepartment_Id(Long departmentId);

    //    @Query(nativeQuery = true, value = "select * from users inner join users_roles on users.id = users_roles.users_id where users_roles.roles = :role")
//    User getByRole(String role);
    Optional<User> findByDepartment_IdAndChatId(Long departmentId, String chatId);
    Optional<User> findByDepartment_IdAndChatIdAndPhone(Long departmentId, String chatId, String phone);
    Optional<User> findByChatId( String chatId);

}
