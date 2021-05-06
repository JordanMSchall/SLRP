package com.slrp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.slrp.model.Borrower;
import com.slrp.model.Loan;
import com.slrp.repository.LoanRepository;

@Component
@Scope("singleton")
@PropertySource("classpath:application.properties")
public class LoanService {
	private static final Logger logger = LoggerFactory.getLogger(LoanService.class);
	private static Random rand = new Random();

	@Autowired
	LoanRepository loanRepository;

	public void createLoan(Loan loan) {
		loanRepository.save(loan);
	}

	public void updateLoan(Loan loan) {
		loanRepository.save(loan);
	}

	public void deleteLoan(Loan loan) {
		loanRepository.delete(loan);
	}

	public Optional<Loan> getLoan(Loan loan) {
		return loanRepository.findById(loan.getId());
	}

	public Iterable<Loan> getLoans() {
		// TODO Auto-generated method stub
		return loanRepository.findAll();
	}

	public Loan findRandomLoan() {
		Iterable<Loan> iterable = loanRepository.findAll();
		List<Loan> result = new ArrayList<Loan>();
		iterable.forEach(result::add);
		if (result.isEmpty())
			return null;
		else
			result.get(rand.nextInt(result.size()));
		return null;
	}

	public Loan getLoanByDoeId(String id) {
		List<Loan> result = loanRepository.findLoanByLoanDoeId(id);
		if (result.isEmpty())
			return null;
		else
			return result.get(0);
	}

	public Loan getLoanByDoeIdAndBorrower(String loanId, Borrower borrower) {
		List<Loan> result = loanRepository.findLoanByLoanDoeIdAndBorrower(loanId, borrower);
		if (result.isEmpty())
			return null;
		else
			return result.get(0);
	}

}
