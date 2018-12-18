package com.hibernateAnnotations;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {

	public static void main(String[] args) {
		
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Employee e = new Employee();

		e.setEid(105);
		e.setEname("Nisha");
		e.setSalary(25000);

		Transaction tx = session.beginTransaction();
		session.save(e);
		System.out.println("Object saved successfully using annotations.....!!");
		tx.commit();
		session.close();
		factory.close();
	}

}
