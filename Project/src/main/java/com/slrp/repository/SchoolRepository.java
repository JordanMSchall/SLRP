package com.slrp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.slrp.model.School;


@Repository
public interface SchoolRepository extends CrudRepository<School, Long> {}

