package com.slrp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.slrp.model.Organization;


@Repository
public interface OrganizationRepository extends CrudRepository<Organization, Long> {}

