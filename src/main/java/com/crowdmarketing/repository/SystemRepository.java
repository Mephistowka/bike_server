package com.crowdmarketing.repository;

import com.crowdmarketing.model.user.entity.System;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SystemRepository extends CrudRepository<System, Long> {
    @Query("select s from System s where s.user.id =:userId")
    List<System> findByUserId(@Param("userId") Long userId);
}
