package com.springbootexampledatamaven.datamaven.repository;

import com.springbootexampledatamaven.datamaven.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepoUser extends CrudRepository<User, Long> {
    List<User> findByLastName(String lastName);
    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.isDeleted = true WHERE u.id = :id")
    void softDelete(@Param("id") Long id);
}
