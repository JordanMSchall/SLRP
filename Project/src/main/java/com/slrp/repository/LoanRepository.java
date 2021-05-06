package com.slrp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.slrp.model.Borrower;
import com.slrp.model.Loan;

@Repository
public interface LoanRepository extends CrudRepository<Loan, Long> {
	List<Loan> findLoanByLoanDoeId(String id);

	List<Loan> findLoanByLoanDoeIdAndBorrower(String loanId, Borrower borrower);

}
