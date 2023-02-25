package com.hazemuh.baseTemplate.repository;

import com.hazemuh.baseTemplate.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface transactionsRepository extends JpaRepository<Transactions, String> {
    @Query(value = "SELECT * FROM project.transactions" , nativeQuery = true)
    List<Transactions> getDataTesting();

}
