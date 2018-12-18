package com.hibernateAnnotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class Get {

	public static void main(String[] args) {

		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Employee e = (Employee) session.get(Employee.class, 105);

		System.out.println(e.getEid() + "\t" + e.getEname() + "\t" + e.getSalary());
		System.out.println("Object fetched successfully using annotations.....!!");
		session.close();
		factory.close();
	}

}
