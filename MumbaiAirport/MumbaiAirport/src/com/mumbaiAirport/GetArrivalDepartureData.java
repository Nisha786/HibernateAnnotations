package com.mumbaiAirport;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mumbaiAirport.ArrivalsDTO;
import com.mumbaiAirport.DepartureDTO;

public class GetArrivalDepartureData {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Query qry = session.createQuery("from ArrivalsDTO a");

		List l = qry.list();
		Iterator it = l.iterator();
		while (it.hasNext()) {
			Object o = it.next();
			ArrivalsDTO a1 = (ArrivalsDTO) o;
			System.out.println(a1.getArrivalId() + "\t" + a1.getCarrier() + "\t" + a1.getOrigin() + "\t"
					+ a1.getArrivalDate() + "\t" + a1.getArrivalTime() + "\t" + a1.getStatus());
			Terminal1DTO t1 = a1.getParent5();
			System.out.println(t1.getTerminal1Id() + "\t" + t1.getTerminal1Name() + "\t" + t1.getFlights());
			System.out.println("All Arrivals from Terminal1 has been selected..!!");

		}

		Query qry2 = session.createQuery("from ArrivalsDTO a");

		List l2 = qry2.list();
		Iterator it2 = l2.iterator();
		while (it2.hasNext()) {
			Object o = it2.next();
			ArrivalsDTO a2 = (ArrivalsDTO) o;
			System.out.println(a2.getArrivalId() + "\t" + a2.getCarrier() + "\t" + a2.getOrigin() + "\t"
					+ a2.getArrivalDate() + "\t" + a2.getArrivalTime() + "\t" + a2.getStatus());
			Terminal2DTO t2 = a2.getParent6();
			System.out.println(t2.getTerminal2Id() + "\t" + t2.getTerminal2Name() + "\t" + t2.getFlights());
			System.out.println("All Arrivals from Terminal2 has been selected..!!");

		}

		Query qry3 = session.createQuery("from DepartureDTO d");

		List l3 = qry3.list();
		Iterator it3 = l3.iterator();
		while (it3.hasNext()) {
			Object o = it3.next();
			DepartureDTO d1 = (DepartureDTO) o;
			System.out.println(d1.getDepartureId() + "\t" + d1.getCarrier() + "\t" + d1.getDestination() + "\t"
					+ d1.getDepartureDate() + "\t" + d1.getDepartureTime() + "\t" + d1.getStatus());
			Terminal1DTO t1 = d1.getParent3();
			System.out.println(t1.getTerminal1Id() + "\t" + t1.getTerminal1Name() + "\t" + t1.getFlights());
			System.out.println("All Departures from Terminal1 has been selected..!!");

		}

		Query qry4 = session.createQuery("from DepartureDTO d");

		List l4 = qry4.list();
		Iterator it4 = l4.iterator();
		while (it3.hasNext()) {
			Object o = it3.next();
			DepartureDTO d2 = (DepartureDTO) o;
			System.out.println(d2.getDepartureId() + "\t" + d2.getCarrier() + "\t" + d2.getDestination() + "\t"
					+ d2.getDepartureDate() + "\t" + d2.getDepartureTime() + "\t" + d2.getStatus());
			Terminal2DTO t2 = d2.getParent4();
			System.out.println(t2.getTerminal2Id() + "\t" + t2.getTerminal2Name() + "\t" + t2.getFlights());
			System.out.println("All Departures from Terminal2 has been selected..!!");

		}

		session.close();
		factory.close();
	}

}
