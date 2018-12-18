package com.hibernateAnnotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class CreateData {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();

		Director d = new Director();

		d.setDirectorId(100);
		d.setDirectorName("Director");

		Actor a1 = new Actor();

		a1.setActorId(504);
		a1.setActorName("Actor1");
		a1.setParent(d);

		Actor a2 = new Actor();

		a2.setActorId(505);
		a2.setActorName("Actor2");
		a2.setParent(d);

		Actor a3 = new Actor();

		a3.setActorId(506);
		a3.setActorName("Actor3");
		a3.setParent(d);

		Transaction tx = session.beginTransaction();

	
		session.save(a1);
		session.save(a2);
		session.save(a3);

		tx.commit();
		session.close();
		System.out.println("Many to One with annotation done...!!");
		factory.close();
	}

}
