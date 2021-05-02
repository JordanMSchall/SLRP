package com.slrp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.slrp.model.ContributionProgram;

@Repository
public interface ContributionProgramRepository extends CrudRepository<ContributionProgram, Long> {}

