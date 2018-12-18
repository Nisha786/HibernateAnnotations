package com.hibernateAnnotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ForSave {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Transaction t = session.beginTransaction();

		Country cn = new Country();
		cn.setCountryName("India");

		State s = new State();
		s.setCountryName("Pakistan");
		s.setStateName("MadhyaPradesh");
		s.setState_type("st");		

		City c = new City();
		c.setCountryName("ShriLanka");
		c.setCity_type("ct");
		c.setCityName("Indore");

		session.save(cn);
		session.save(s);
		session.save(c);

		t.commit();
		session.close();
		System.out.println("success");
	}
}
