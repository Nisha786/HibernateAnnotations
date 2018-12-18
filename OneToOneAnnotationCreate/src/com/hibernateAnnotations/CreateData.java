package com.hibernateAnnotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class CreateData {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Customer c = new Customer();
		c.setCustId(101);
		c.setCustName("James");

		Vendor v = new Vendor();
		v.setVid(1);
		v.setVname("Gerry");

		c.setParent(v);
		Transaction tx = session.beginTransaction();
		session.save(c);
		tx.commit();
		session.close();
		System.out.println("One to One with annotations is done..!!!!");
		factory.close();
	}

}
