package com.hazemuh.baseTemplate.repository;

import com.hazemuh.baseTemplate.entity.Transactions;
import com.hazemuh.baseTemplate.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface transactionsRepository extends JpaRepository<Transactions, String> {
    @Query(value = "SELECT * FROM project.transactions" , nativeQuery = true)
    List<Transactions> getDataTesting();

    @Query(value = "SELECT * FROM project.transactions where users_id=:id" , nativeQuery = true)
    List<Transactions> getTransactionbyUserId(@Param("id") UUID id);

    @Query(value = "SELECT * FROM project.transactions where transactions_id=:id" , nativeQuery = true)
    Transactions getTransactionsbyId(@Param("id") UUID id);

}
