package com.hibernateAnnotations;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateData {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();

		Object o = session.get(Mobile.class, new Integer(1));
		Mobile m = (Mobile) o;
		m.setMobileName("Samsung");

		Set s = m.getHotspots();
		Iterator it = s.iterator();

		while (it.hasNext()) {

			Object o1 = it.next();
			Hotspot h = (Hotspot) o1;
            h.setHotspotName("Hotspot2");
		}
		session.update(m);
		tx.commit();
		System.out.println("Successfully Done Update Many To Many...!!");
		session.close();
		factory.close();
	}

}
