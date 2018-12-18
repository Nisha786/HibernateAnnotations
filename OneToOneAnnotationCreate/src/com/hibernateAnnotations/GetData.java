package com.hibernateAnnotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetData {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Object o = session.get(Customer.class, new Integer(101));
		Customer c = (Customer) o;
		System.out.println(c.getCustName());

		Vendor v = c.getParent();
		System.out.println(v.getVname());

		session.close();
		System.out.println("One to One is Done..!!");
	}

}
