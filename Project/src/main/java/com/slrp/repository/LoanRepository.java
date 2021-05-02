package com.slrp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.slrp.model.Loan;


@Repository
public interface LoanRepository extends CrudRepository<Loan, Long> {}



