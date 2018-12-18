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

		Candidate e1 = new Candidate();
		e1.setName("Gaurav Chawla");

		Regular_Emp e2 = new Regular_Emp();
		e2.setName("Vivek Kumar");
		e2.setSalary(50000);
		e2.setBonus(5);

		Contract_Emp e3 = new Contract_Emp();
		e3.setName("Arjun Kumar");
		e3.setPay_per_hour(1000);
		e3.setContract_duration("15 hours");

		session.save(e1);
		session.save(e2);
		session.save(e3);

		t.commit();
		session.close();
		System.out.println("success");
	}

}
