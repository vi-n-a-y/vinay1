package com.vin.hibernate_demo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure();
//		cfg.configure();

		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();

		First_Class fc = new First_Class();
		fc.setId(13);
		fc.setName("sampath");
		fc.setMarks(69);

		try {
			Transaction tx = session.beginTransaction();
//			session.persist(fc);
			System.out.println("the save will give the " + session.save(fc));
			tx.commit();
		} catch (HibernateException HiEx) {
			HiEx.printStackTrace();

		} finally {
			session.close();
			sessionFactory.close();
		}

	}

}
