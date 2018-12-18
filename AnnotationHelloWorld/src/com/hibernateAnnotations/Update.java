package com.hibernateAnnotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class Update {

	public static void main(String[] args) {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
        
		Object o = session.get(Employee.class, new Integer(105));
		Employee e = (Employee)o;
		e.setEname("Pinky");
		e.setSalary(20000);

		Transaction tx = session.beginTransaction();
		System.out.println("Object saved successfully using annotations.....!!");
		session.update(e);
		tx.commit();
		session.close();
		factory.close();
	}

}
