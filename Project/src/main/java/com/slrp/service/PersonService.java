package com.slrp.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.slrp.model.Person;
import com.slrp.repository.PersonRepository;

@Component
@Scope("singleton")
@PropertySource("classpath:application.properties")
public class PersonService {
	private static final Logger logger = LoggerFactory.getLogger(PersonService.class);
	@Autowired
	PersonRepository personRepository;

	public void createPerson(Person person) {
		personRepository.save(person);
	}

	public void deletePerson(Person person) {
		personRepository.delete(person);
	}

	public Optional<Person> getPerson(Person person) {
		return personRepository.findById(person.getId());
	}

	public Iterable<Person> getPersons() {
		// TODO Auto-generated method stub
		return personRepository.findAll();
	}

	public void updatePerson(Person person) {
		personRepository.save(person);
	}

}
