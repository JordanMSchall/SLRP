package com.slrp.beans.service;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

/**
 * @since JavaSE-1.8
 */
@Service
public class DatabaseService {

	static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory != null) {
			return sessionFactory;
		}
		sessionFactory = new Configuration().configure().buildSessionFactory();
		return sessionFactory;
	}


	public static Session getSession() {
		getSessionFactory();
		return sessionFactory.openSession();
	}
	
	public static Transaction getTransaction(Session s) {
		return s.beginTransaction();
	}
	
	public static  void closeTransaction(Transaction t) {
		if ( t.isActive())
			t.commit();
	}
	
	public static void closeSession(Session s) {
		if ( s.isOpen() ) {
			s.close();
		}
	}
	

}