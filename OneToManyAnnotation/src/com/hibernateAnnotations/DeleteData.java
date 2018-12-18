package com.hibernateAnnotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteData {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		Object o = session.get(Children.class, new Integer(100));
		Children c = (Children) o;
		Transaction tx = session.beginTransaction();
		session.delete(c);
		tx.commit();

		session.close();
		System.out.println("One To Many is Done for delete..!!");
		factory.close();
	}

}
