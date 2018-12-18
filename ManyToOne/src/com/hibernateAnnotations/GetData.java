package com.hibernateAnnotations;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetData {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		// for select one child object with Parent
		/*
		 * Object o = session.get(Actor.class, new Integer(506)); Actor a =
		 * (Actor) o;
		 * 
		 * System.out.println(a.getActorName()); Director d = a.getParent();
		 * System.out.println(d.getDirectorName());
		 */
        
		// for select all child objects with parent
		Query qry = session.createQuery("from Actor a");

		List l = qry.list();
		Iterator it = l.iterator();
		while (it.hasNext()) {
			Object o = it.next();
			Actor a = (Actor) o;
			System.out.println(a.getActorName());
			Director d = a.getParent();
			System.out.println(d.getDirectorName());
		}

		session.close();
		System.out.println("many to one select is done..!!");
		factory.close();
	}

}
