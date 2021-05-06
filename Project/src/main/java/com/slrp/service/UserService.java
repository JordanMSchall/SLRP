package com.slrp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.slrp.model.Borrower;
import com.slrp.model.Contributor;
import com.slrp.model.User;
import com.slrp.repository.BorrowerRepository;
import com.slrp.repository.PersonRepository;
import com.slrp.repository.UserRepository;

@Component
@Scope("singleton")
@PropertySource("classpath:application.properties")
public class UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	@Autowired
	UserRepository userRepository;
	@Autowired
	PersonRepository personRepository;
	@Autowired
	BorrowerRepository borrowerRepository;

	@Value("${profile.version}")
	private String version;

	public void createProfile(User user) {
		personRepository.save(user.getPerson());
		userRepository.save(user);
	}

	public void deleteProfile(User user) {
		personRepository.delete(user.getPerson());
		userRepository.delete(user);
	}

	public Optional<User> getProfile(User user) {
		return userRepository.findById(user.getId());
	}

	public void createProfile(Borrower b) {
		personRepository.save(b.getPerson());
		userRepository.save(b.getPerson().getUser());
		borrowerRepository.save(b);
	}

	public static String addAddress() {
		// TODO Auto-generated method stub
		return "Add Address!";
	}

	public void createProfile(Contributor c) {
		personRepository.save(c.getPerson());
		userRepository.save(c.getPerson().getUser());

	}

	public User verifyUser(String username, String password) {
		// TODO Auto-generated method stub
		List<User> list = userRepository.findByUsername(username);
		if (list.isEmpty())
			return null;
		User u = list.get(0);

		if (u != null && u.getPassword().equals(password))
			return u;
		return null;
	}

	public User checkUsername(String username) {
		// TODO Auto-generated method stub
		List<User> list = userRepository.findByUsername(username);
		if (list.isEmpty())
			return null;
		return list.get(0);
	}
}
