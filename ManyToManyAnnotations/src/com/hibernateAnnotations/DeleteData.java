package com.hibernateAnnotations;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteData {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		Query qry = session.createQuery("from Mobile m");
		List l = qry.list();
		Iterator it = l.iterator();

		Transaction tx = session.beginTransaction();

		while (it.hasNext()) {

			Object o = it.next();
			Mobile m = (Mobile) o;
			session.delete(m);
		}

		tx.commit();

		session.close();
		System.out.println("One To Many is Done for deleting all parents with childs...!");
		factory.close();
	}

}
