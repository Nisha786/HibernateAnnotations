package com.hibernateAnnotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchTest {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session1 = factory.openSession();
		Department101 d1 = (Department101) session1.load(Department101.class, 101);
		System.out.println(d1.getId() + "\t" + d1.getName());
		session1.close();

		Session session2 = factory.openSession();
		Department101 d2 = (Department101) session2.load(Department101.class, 101);
		System.out.println(d2.getId() + "\t" + d2.getName());
		session2.close();

		// Output = hibernate does not fire query twice. If you don't use second
		// level cache, hibernate will fire query twice because both query uses
		// different session objects
	}

}
