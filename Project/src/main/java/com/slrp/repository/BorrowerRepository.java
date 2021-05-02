package com.slrp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.slrp.model.Borrower;

@Repository
public interface BorrowerRepository extends CrudRepository<Borrower, Long> {}

