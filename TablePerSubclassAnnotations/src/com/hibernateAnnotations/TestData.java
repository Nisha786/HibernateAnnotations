package com.hibernateAnnotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestData {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Transaction t = session.beginTransaction();

		Customer c = new Customer();
		c.setName("Akash");

		Product p = new Product();
		p.setName("Archana");
		p.setProductId(501);
		p.setProductName("Shirt");

		Delivery d = new Delivery();
		d.setName("Akansha");
		d.setDeliveryId(502);
		d.setDeliveryName("Indore");

		session.save(c);
		session.save(p);
		session.save(d);

		t.commit();
		session.close();
		System.out.println("success");
	}

}
