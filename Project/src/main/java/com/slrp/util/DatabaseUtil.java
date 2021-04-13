package com.slrp.util;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.slrp.api.model.Contributor;
import com.slrp.api.model.Contributor.Contribution;
import com.slrp.api.model.Student;
import com.slrp.api.model.Student.Loan;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @since JavaSE-1.8
 */
public class DatabaseUtil {

	public static List<?> getSchoolLoans() {
		return new ArrayList<String>();
	}

	public static Student getStudent() {
		int loansToGenerate = 5;
		ArrayList<Loan> loans = new  ArrayList<Loan>();
		Random rand = new Random();
		//amnt, interest, ID
		for (int k = 0; k < loansToGenerate + 1; k++) {
			Loan l = new Loan(5000 + rand.nextInt(50000), rand.nextDouble(), Integer.toString(1000 + rand.nextInt(9999)), "Great Lakes");
			loans.add(l);
		}
		Student a = new Student("John", "402-999-9999", "12345 Fake St", loans );
		return a;
	}

	/**
		 * Because we do not have the database connection yet, this is here to create a mockup contributor.
		 * @return returns a generated contributor.
		 */
	public static Contributor createContributor() {
		Contributor c = new Contributor("Louis Nodskov", "4025555555", "1234 Pine Street");
		//c.addContribution(new Contribution(new Loan(0, 0, null), 0, null));
		Loan l = new Loan(5000, 100.0, "12345");
		Loan l1 = new Loan(6000, 125.0, "54321");
		Contribution c1 = new Contribution(l, 50.50, "4/12/2021");
		Contribution c2 = new Contribution(l, 50.50, "4/12/2021");
		Contribution c3 = new Contribution(l1, 120.42, "4/3/2021");
		c.addContribution(c1);
		c.addContribution(c2);
		c.addContribution(c3);
		return c;
	}


//	static SessionFactory sessionFactory = null;
//
//	public static SessionFactory getSessionFactory() {
//		if (sessionFactory != null) {
//			return sessionFactory;
//		}
//		Configuration configuration = new Configuration().configure();
//		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
//				.applySettings(configuration.getProperties());
//		sessionFactory = configuration.buildSessionFactory(builder.build());
//		return sessionFactory;
//	}
//
//	public static List<Post> listPosts() {
//		List<Post> resultList = new ArrayList<Post>();
//
//		Session session = getSessionFactory().openSession();
//		Transaction tx = null; // each process needs transaction and commit the changes in DB.
//
//		try {
//			tx = session.beginTransaction();
//			List<?> Posts = session.createQuery("FROM Post").list();
//			for (Iterator<?> iterator = Posts.iterator(); iterator.hasNext();) {
//				Post Post = (Post) iterator.next();
//				resultList.add(Post);
//			}
//			tx.commit();
//		} catch (HibernateException e) {
//			if (tx != null)
//				tx.rollback();
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
//		return resultList;
//	}
//
//	public static void createPost(String title, String body) {
//		Session session = getSessionFactory().openSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			session.save(new Post(title, body));
//			tx.commit();
//		} catch (HibernateException e) {
//			if (tx != null)
//				tx.rollback();
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
//	}
//
//	public static List<Post> findPosts( String keyword) {
//		List<Post> resultList = new ArrayList<Post>();
//
//		Session session = getSessionFactory().openSession();
//		Transaction tx = null; // each process needs transaction and commit the changes in DB.
//
//		try {
//			tx = session.beginTransaction();
//			String sql = " SELECT * FROM Post P where P.post_body like  '%" + keyword + "%'  or P.title like '%" + keyword + "%';";
//			SQLQuery query = session.createSQLQuery(sql);
//			query.addEntity(Post.class);
//			List<?> Posts = query.list();
//			for (Iterator<?> iterator = Posts.iterator(); iterator.hasNext();) {
//				Post Post = (Post) iterator.next();
//				resultList.add(Post);
//			}
//			tx.commit();
//		} catch (HibernateException e) {
//			if (tx != null)
//				tx.rollback();
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
//		return resultList;
//	}

	== == == =
	    package com.slrp.util;

	import java.util.List;
	import java.util.Random;
	import java.util.ArrayList;
	import java.util.Iterator;
	import org.hibernate.SessionFactory;
	import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
	import org.hibernate.cfg.Configuration;

	import com.slrp.api.model.Student;
	import com.slrp.api.model.Student.Loan;

	import org.hibernate.HibernateException;

	import org.hibernate.Session;
	import org.hibernate.Transaction;

	/**
	 * @since JavaSE-1.8
	 */
	public class DatabaseUtil {





//	static SessionFactory sessionFactory = null;
//
//	public static SessionFactory getSessionFactory() {
//		if (sessionFactory != null) {
//			return sessionFactory;
//		}
//		Configuration configuration = new Configuration().configure();
//		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
//				.applySettings(configuration.getProperties());
//		sessionFactory = configuration.buildSessionFactory(builder.build());
//		return sessionFactory;
//	}
//
//	public static List<Post> listPosts() {
//		List<Post> resultList = new ArrayList<Post>();
//
//		Session session = getSessionFactory().openSession();
//		Transaction tx = null; // each process needs transaction and commit the changes in DB.
//
//		try {
//			tx = session.beginTransaction();
//			List<?> Posts = session.createQuery("FROM Post").list();
//			for (Iterator<?> iterator = Posts.iterator(); iterator.hasNext();) {
//				Post Post = (Post) iterator.next();
//				resultList.add(Post);
//			}
//			tx.commit();
//		} catch (HibernateException e) {
//			if (tx != null)
//				tx.rollback();
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
//		return resultList;
//	}
//
//	public static void createPost(String title, String body) {
//		Session session = getSessionFactory().openSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			session.save(new Post(title, body));
//			tx.commit();
//		} catch (HibernateException e) {
//			if (tx != null)
//				tx.rollback();
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
//	}
//
//	public static List<Post> findPosts( String keyword) {
//		List<Post> resultList = new ArrayList<Post>();
//
//		Session session = getSessionFactory().openSession();
//		Transaction tx = null; // each process needs transaction and commit the changes in DB.
//
//		try {
//			tx = session.beginTransaction();
//			String sql = " SELECT * FROM Post P where P.post_body like  '%" + keyword + "%'  or P.title like '%" + keyword + "%';";
//			SQLQuery query = session.createSQLQuery(sql);
//			query.addEntity(Post.class);
//			List<?> Posts = query.list();
//			for (Iterator<?> iterator = Posts.iterator(); iterator.hasNext();) {
//				Post Post = (Post) iterator.next();
//				resultList.add(Post);
//			}
//			tx.commit();
//		} catch (HibernateException e) {
//			if (tx != null)
//				tx.rollback();
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
//		return resultList;
//	}

		>>> >>> > origin / connorp
	}