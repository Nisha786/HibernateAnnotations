package com.mumbaiAirport;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.mumbaiAirport.ArrivalsDTO;
import com.mumbaiAirport.Terminal1DTO;

public class DeleteArrivalDeparture {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();

		Query qry = session.createQuery("from ArrivalsDTO a");
		List l = qry.list();
		Iterator it = l.iterator();

		while (it.hasNext()) {

			Object o = it.next();
			ArrivalsDTO a = (ArrivalsDTO) o;
			session.delete(a);
		}
		
		Query qry2 = session.createQuery("from DepartureDTO d");
		List l2 = qry2.list();
		Iterator it2 = l2.iterator();

		while (it2.hasNext()) {

			Object o = it2.next();
			DepartureDTO d = (DepartureDTO) o;
			session.delete(d);
		}
		Transaction tx = session.beginTransaction();
		
		tx.commit();

		session.close();
		System.out.println("many to one delete done..!!");
		factory.close();
	}

}
