package com.slrp.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.slrp.model.Borrower;
import com.slrp.model.Person;
import com.slrp.repository.BorrowerRepository;

@Component
@Scope("singleton")
@PropertySource("classpath:application.properties")
public class BorrowerService {

	private static final Logger logger = LoggerFactory.getLogger(BorrowerService.class);
	@Autowired
	BorrowerRepository borrowerRepository;

	public void makeBorrower(Borrower cont) {
		borrowerRepository.save(cont);
	}

	public Iterable<Borrower> getBorrowers(Borrower cont) {
		return borrowerRepository.findAll();
	}

	public Optional<Borrower> getBorrower(Borrower c) {
		return borrowerRepository.findById(c.getId());
	}

	public void deleteBorrower(Borrower c) {
		borrowerRepository.delete(c);

	}

	public void createBorrower(Borrower c) {
		makeBorrower(c);
	}

	public Borrower getBorrower(Person p) {
		// TODO Auto-generated method stub
		List<Borrower> list = borrowerRepository.findByPerson(p);
		if (list.isEmpty())
			return null;
		return list.get(0);
	}

	public void updateBorrower(Borrower borrower) {
		borrowerRepository.save(borrower);
	}

}
