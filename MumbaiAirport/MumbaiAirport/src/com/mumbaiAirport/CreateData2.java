package com.mumbaiAirport;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class CreateData2 {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();

		// ManyToOne Terminal and Parking

		Terminal1DTO t1 = new Terminal1DTO();
		t1.setTerminal1Id(101);
		t1.setTerminal1Name("DomesticTerminal1");
		t1.setFlights("AirIndia");

		Terminal2DTO t2 = new Terminal2DTO();
		t2.setTerminal2Id(201);
		t2.setTerminal2Name("InternationalTerminal2");
		t2.setFlights("Vistara");

		ParkingDTO p1 = new ParkingDTO();
		p1.setParkingId(501);
		p1.setParkingType("2 Wheelers");
		p1.setParent1(t1);
		p1.setParent2(t2);

		ParkingDTO p2 = new ParkingDTO();
		p2.setParkingId(502);
		p2.setParkingType("4 Wheelers");
		p2.setParent1(t1);
		p2.setParent2(t2);

		// ManyToMany Transport Parking

		TransportDTO tr1 = new TransportDTO();
		tr1.setId(301);
		tr1.setName("Bus");
		tr1.setParent1(t1);
		tr1.setParent2(t2);

		TransportDTO tr2 = new TransportDTO();
		tr2.setId(302);
		tr2.setName("Taxi");
		tr2.setParent1(t1);
		tr2.setParent2(t2);


		Set s = new HashSet();
		s.add(p1);
		s.add(p2);

		tr1.setParkings(s);
		tr2.setParkings(s);

		Transaction tx = session.beginTransaction();
		session.save(p1);
		session.save(p2);
		session.save(tr1);
		session.save(tr2);
		tx.commit();
		session.close();
		factory.close();

	}

}
