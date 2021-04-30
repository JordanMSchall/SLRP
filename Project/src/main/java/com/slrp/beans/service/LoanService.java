package com.slrp.beans.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.slrp.model.Loan;
import com.slrp.util.DatabaseService;


public class LoanService {
	
	@Autowired
	private static DatabaseService dbservice;
	
	private final static SessionFactory sessionFactory = dbservice.getSessionFactory();
	
	public static List<Loan> listAllLoans() {
		List<Loan> resultList = new ArrayList<Loan>();

		Session session = sessionFactory.openSession();
		Transaction tx = null; // each process needs transaction and commit the changes in DB.

		try {
			tx = session.beginTransaction();
			List<?> Loans = session.createQuery("FROM Loan").list();
			for (Iterator<?> iterator = Loans.iterator(); iterator.hasNext();) {
				Loan Loan = (Loan) iterator.next();
				resultList.add(Loan);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resultList;
	}

}
