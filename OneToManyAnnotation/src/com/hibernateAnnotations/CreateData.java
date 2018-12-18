package com.hibernateAnnotations;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CreateData {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		Children c = new Children();
		c.setChildrenId(100);
		c.setChildrenName("Sahil");

		Mother m1 = new Mother();
		m1.setMotherId(500);
		m1.setMotherName("Mother1");

		Mother m2 = new Mother();
		m2.setMotherId(501);
		m2.setMotherName("Mother2");

		Set s = new HashSet();
		s.add(m1);
		s.add(m2);

		c.setChildren(s);

		Transaction tx = session.beginTransaction();
		session.save(c);
		tx.commit();

		session.close();
		System.out.println("One to Many Annotatios Done...!!!!!!");
		factory.close();
	}

}
