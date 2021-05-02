package com.slrp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.slrp.model.Contribution;

@Repository
public interface ContributionRepository extends CrudRepository<Contribution, Long> {}

