package com.hazemuh.baseTemplate.repository;

import com.hazemuh.baseTemplate.entity.TdTesting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface addDataRepository extends JpaRepository<TdTesting, String> {
    @Query(value = "SELECT * FROM public.td_testing" , nativeQuery = true)
    List<TdTesting> getDataTesting();

}
