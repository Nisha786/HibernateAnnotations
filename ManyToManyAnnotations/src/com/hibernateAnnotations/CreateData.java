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
		Session ses = factory.openSession();	

		Mobile m1 = new Mobile();
		m1.setMobileId(1);
		m1.setMobileName("Oppo");

		Mobile m2 = new Mobile();
		m2.setMobileId(2);
		m2.setMobileName("Mi");

		Hotspot h1=new Hotspot();
		Hotspot h2 = new Hotspot();

		h1.setHotspotId(101);
		h1.setHotspotName("Hotspot1");

		h2.setHotspotId(102);
		h2.setHotspotName("Hotspot2");

		Set  s =new HashSet();
		s.add(h1);
		s.add(h2);

		m1.setHotspots(s);
		m2.setHotspots(s);

		Transaction tx = ses.beginTransaction();
		ses.save(m1);
		ses.save(m2);
		tx.commit();
		System.out.println("Man to Many using annotations been done...!!!!!");
		ses.close();
	}

}
