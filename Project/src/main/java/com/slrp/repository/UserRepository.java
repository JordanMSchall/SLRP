package com.slrp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.slrp.model.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {}

