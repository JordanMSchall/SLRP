package com.slrp.beans.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.slrp.model.Borrower;
import com.slrp.model.User;

@Service
@PropertySource("classpath:application.properties")
public class ProfileService extends DatabaseService {
	  private static final Logger logger = LoggerFactory.getLogger(ProfileService.class);

	
	@Value("${profile.version}")
	private String version;
	
	public void createProfile(User user) {
		// TODO
		logger.info("\n Creating a profile for user:" + user.toString());
		Session s = getSession();
		try {
			 s.persist(user);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			closeSession(s);
		}
	}
	
	public void deleteProfile(User user) {
		// TODO
		logger.info("\n Deleting  user:" + user.toString());
		Session s = getSession();
		try {
			 s.delete(user);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			closeSession(s);
		}
	}
	
	public void updateProfile(User user, String profileType) {
		// TODO
		logger.info("\n Deleting  user:" + user.toString());
		Session s = getSession();
		try {
			 s.merge(user);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			closeSession(s);
		}
	}
	
	public User getProfile(User user) {
		// TODO
		logger.info("\n Deleting  user:" + user.toString());
		Session s = getSession();
		try {
			 return s.get(User.class, user.getId());
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			closeSession(s);
		}
		return null;
	}

	public void createProfile(Borrower b) {
		// TODO
				logger.info("\n Creating a profile for borrower:" + b.toString());
				Session s = getSession();
				Transaction t = getTransaction(s);
				try {
					 s.persist(b);
				} catch (HibernateException e) {
					e.printStackTrace();
				} finally {
					closeTransaction(t);
					closeSession(s);
				}
	}


	public static String addAddress() {
		// TODO Auto-generated method stub
		return "Add Address!";
	}
}
