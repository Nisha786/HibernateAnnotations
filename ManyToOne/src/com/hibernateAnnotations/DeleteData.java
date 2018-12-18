package com.hibernateAnnotations;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class DeleteData {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		Query qry =session.createQuery("from Actor a");
		List l=qry.list();
		Iterator it = l.iterator();

		Transaction tx = session.beginTransaction();

		while(it.hasNext())
		{

		Object o = it.next();
		Actor a = (Actor) o;
		session.delete(a);
		}
		tx.commit();

		session.close();
		System.out.println("many to one delete done..!!");
		factory.close();
	}

}
