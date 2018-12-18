package com.hibernateAnnotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class Delete {

	public static void main(String[] args) {

		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Employee e = new Employee();

		e.setEid(105);
		e.setEname("Pinky");
		e.setSalary(20000);

		Transaction tx = session.beginTransaction();
		session.delete(e);
		tx.commit();
		System.out.println("Object deleted successfully using annotations.....!!");
		session.close();
		factory.close();
	}

}
