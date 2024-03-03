package com.springbootexampledatamaven.datamaven.repository;

import com.springbootexampledatamaven.datamaven.entity.User;
import org.hibernate.boot.archive.scan.internal.ScanResultImpl;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepoUser extends CrudRepository<User, Long> {
    List<User> findByLastName(String lastName);
}
