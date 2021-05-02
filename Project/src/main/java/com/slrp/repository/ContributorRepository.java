package com.slrp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.slrp.model.Contributor;


@Repository
public interface ContributorRepository extends CrudRepository<Contributor, Long> {}

