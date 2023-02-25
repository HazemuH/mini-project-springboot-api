package com.hazemuh.baseTemplate.repository;

import com.hazemuh.baseTemplate.entity.Transactions;
import com.hazemuh.baseTemplate.entity.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface usersRepository extends JpaRepository<Users, UUID> {
    @Query(value = "SELECT * FROM project.users" , nativeQuery = true)
    List<Users> getAllUsers();

    @Query(value = "SELECT * FROM project.users where users_id=:id" , nativeQuery = true)
    Users getUsersbyId(@Param("id") UUID id);

}
