package com.mumbaiAirport;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetTerminalParkingData {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		Query qry = session.createQuery("from ParkingDTO p");

		List l1 = qry.list();
		Iterator it1 = l1.iterator();
		while (it1.hasNext()) {
			Object o = it1.next();
			ParkingDTO p1 = (ParkingDTO) o;
			System.out.println("---------------------------");
			System.out.println(p1.getParkingId() + "\t" + p1.getParkingType());
			Terminal1DTO t1 = p1.getParent1();
			System.out.println(t1.getTerminal1Id() + "\t" + t1.getTerminal1Name() + "\t" + t1.getFlights());
			System.out.println("---------------------------");
			System.out.println("Parkings from Terminal1 has been selected.....!");
		}

		Query qry2 = session.createQuery("from ParkingDTO p");

		List l2 = qry2.list();
		Iterator it2 = l2.iterator();
		while (it2.hasNext()) {
			Object o2 = it2.next();
			ParkingDTO p2 = (ParkingDTO) o2;
			System.out.println("---------------------------");
			System.out.println(p2.getParkingId() + "\t" + p2.getParkingType());
			Terminal2DTO t2 = p2.getParent2();
			System.out.println(t2.getTerminal2Id() + "\t" + t2.getTerminal2Name() + "\t" + t2.getFlights());
			System.out.println("---------------------------");
			System.out.println("Parkings from Terminal2 has been selected.....!");
		}

		Object o3 = session.get(TransportDTO.class, new Integer(301));
		TransportDTO tr1 = (TransportDTO) o3;
		System.out.println(tr1.getId() + "\t" + tr1.getName());

		Set s1 = tr1.getParkings();
		Iterator it3 = s1.iterator();

		while (it3.hasNext()) {

			Object o4 = it3.next();
			ParkingDTO p3 = (ParkingDTO) o4;

			System.out.println("---------------------------");
			System.out.println(p3.getParkingId() + "\t" + p3.getParkingType());
			System.out.println("---------------------------");
			System.out.println("Transports from Parking has been selected.....!");
		}

	}

}
