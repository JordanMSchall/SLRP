package com.slrp.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.slrp.model.Person;
import com.slrp.repository.PersonRepository;

@Component
@PropertySource("classpath:application.properties")
public class PersonService {
	private static final Logger logger = LoggerFactory.getLogger(PersonService.class);
	@Autowired
	PersonRepository personRepository;

	public void createPerson(Person loan) {
		personRepository.save(loan);
	}

	public void deletePerson(Person loan) {
		personRepository.delete(loan);
	}

	public Optional<Person> getPerson(Person loan) {
		return personRepository.findById(loan.getId());
	}

	public Iterable<Person> getPersons() {
		// TODO Auto-generated method stub
		return personRepository.findAll();
	}

}
