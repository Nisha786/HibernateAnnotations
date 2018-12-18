package com.hibernateAnnotations;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class GetData {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		Object o = session.get(Mobile.class, new Integer(1));
		Mobile m = (Mobile) o;
		System.out.println(m.getMobileId() + "\t" + m.getMobileName());

		Set s = m.getHotspots();
		Iterator it = s.iterator();

		while (it.hasNext()) {

			Object o1 = it.next();
			Hotspot h = (Hotspot) o1;

			System.out.println("---------------------------");
			System.out.println(h.getHotspotId() + "\t" + h.getHotspotName());
			System.out.println("---------------------------");
		}

		session.close();
		System.out.println("One To Many is Done for selecting.....!");
		factory.close();
	}

}
