package com.mumbaiAirport;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class UpdateData2 {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();

		// ManyToOne Terminal and Parking

		Terminal1DTO t1 = new Terminal1DTO();
		t1.setTerminal1Id(101);
		t1.setTerminal1Name("DomesticTerminal1");
		t1.setFlights("Air Deccan");

		Terminal2DTO t2 = new Terminal2DTO();
		t2.setTerminal2Id(201);
		t2.setTerminal2Name("InternationalTerminal1");
		t2.setFlights("Air India Express");

		ParkingDTO p1 = new ParkingDTO();
		p1.setParkingId(501);
		p1.setParkingType("2 Wheeler");
		p1.setParent1(t1);
		p1.setParent2(t2);

		ParkingDTO p2 = new ParkingDTO();
		p2.setParkingId(502);
		p2.setParkingType("4 Wheeler");
		p2.setParent1(t1);
		p2.setParent2(t2);

		// ManyToMany Transport Parking

		TransportDTO tr1 = new TransportDTO();
		tr1.setId(301);
		tr1.setName("Buses");
		tr1.setParent1(t1);
		tr1.setParent2(t2);

		TransportDTO tr2 = new TransportDTO();
		tr2.setId(302);
		tr2.setName("Taxies");
		tr2.setParent1(t1);
		tr2.setParent2(t2);

		Transaction tx = session.beginTransaction();
		session.update(p1);
		session.update(p2);
		session.update(tr1);
		session.update(tr2);
		session.update(t1);
		session.update(t2);
		tx.commit();
		session.close();
		factory.close();
	}

}
