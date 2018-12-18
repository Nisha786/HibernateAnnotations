package com.hibernateAnnotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Update {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Object o = session.get(Customer.class, new Integer(101));
		Customer c = (Customer) o;
		c.setCustName("Nick");

		Vendor v = c.getParent();
		v.setVname("Michel");
         
		Transaction tx = session.beginTransaction();
		session.update(c);
		tx.commit();
		session.close();
		System.out.println("One to One is Done..!!");
	}

}
