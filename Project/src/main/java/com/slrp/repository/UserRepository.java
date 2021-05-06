package com.slrp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.slrp.model.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	List<User> findByUsername(String username);
	
}

