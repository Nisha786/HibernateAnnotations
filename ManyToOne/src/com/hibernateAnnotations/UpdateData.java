package com.hibernateAnnotations;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class UpdateData {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();

		Director d = new Director(); // parent object
		d.setDirectorId(100);
		d.setDirectorName("Director1");

		Actor a1 = new Actor(); // Child object
		a1.setActorId(504);
		a1.setActorName("Actor4");
		a1.setParent(d);

		Actor a2 = new Actor();
		a2.setActorId(505);
		a2.setActorName("Actor5");
		a2.setParent(d);

		Actor a3 = new Actor();
		a3.setActorId(506);
		a3.setActorName("Actor6");
		a3.setParent(d);

		Transaction tx = session.beginTransaction();
		session.update(d);
		tx.commit();
		session.close();
		System.out.println("One to many is done successfully.....!!");
		factory.close();
	}

}
