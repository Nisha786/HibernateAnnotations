package com.mumbaiAirport;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.mumbaiAirport.*;

public class DeleteCarParking {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();

		Query qry = session.createQuery("from ParkingDTO p");
		List l = qry.list();
		Iterator it = l.iterator();

		while (it.hasNext()) {

			Object o = it.next();
			ParkingDTO p = (ParkingDTO) o;
			session.delete(p);
		}

		Query qry2 = session.createQuery("from CarRentalDTO c");
		List l2 = qry2.list();
		Iterator it2 = l2.iterator();

		while (it2.hasNext()) {

			Object o2 = it2.next();
			CarRentalDTO c = (CarRentalDTO) o2;
			session.delete(c);
		}

		Query qry3 = session.createQuery("from HotelsDTO h");
		List l3 = qry3.list();
		Iterator it3 = l3.iterator();

		while (it3.hasNext()) {

			Object o3 = it3.next();
			HotelsDTO h = (HotelsDTO) o3;
			session.delete(h);
		}

		Transaction tx = session.beginTransaction();

		tx.commit();

		session.close();
		System.out.println("many to one delete done..!!");
		factory.close();
	}

}
