package com.slrp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.slrp.model.Borrower;
import com.slrp.model.Person;

@Repository
public interface BorrowerRepository extends CrudRepository<Borrower, Long> {
	List<Borrower> findByPerson(Person person);
	
}

