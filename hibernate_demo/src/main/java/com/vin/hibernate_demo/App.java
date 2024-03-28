package com.vin.hibernate_demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {

    	Session session = HibernateUtil.getSessionFactory().openSession();
//		SessionFactory sf = new Configuration().configure().buildSessionFactory();
//		Session session = sf.openSession();

		session.beginTransaction();
		First_Class fc = new First_Class();
//       fc.setId(6);
		fc.setName("chaitu");
		fc.setMarks(76);

		session.persist(fc);
		session.getTransaction().commit();
		session.close();
	}
}

////Configuration con = new Configuration().configure();
////SessionFactory sf= con.buildSessionFactory();
////
//SessionFactory sf = new Configuration().configure().buildSessionFactory();
//
//Session session = sf.openSession();
