package com.slrp.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
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
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}

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

}