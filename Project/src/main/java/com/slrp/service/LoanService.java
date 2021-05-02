package com.slrp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import org.springframework.stereotype.Component;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.slrp.model.Loan;
import com.slrp.repository.LoanRepository;

@Component
@PropertySource("classpath:application.properties")
public class LoanService {
	private static final Logger logger = LoggerFactory.getLogger(LoanService.class);
	@Autowired
	LoanRepository loanRepository;

	public void createLoan(Loan loan) {
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

}
