package com.mumbaiAirport;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class CreateCarParking {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();

		// ManyToMany CarRental Parking
        
		//for reference of t1 and t2 for 505 and 506
		
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

		CarRentalDTO c1 = new CarRentalDTO();
		c1.setCarId(1);
		c1.setCompany("Avis");
		c1.setMobileno(1244724850);

		CarRentalDTO c2 = new CarRentalDTO();
		c2.setCarId(2);
		c2.setCompany("Carjee");
		c2.setMobileno(1226533141);
		
		// Many to One Hotels, T1 & T2
		
		HotelsDTO h1 = new HotelsDTO();
		h1.setHotelId(1102);
		h1.setHotelName("Hotel Sahara");
		h1.setRating("5 Star");
		h1.setParent3(t1);
		h1.setParent4(t2);
		
		HotelsDTO h2 = new HotelsDTO();
		h2.setHotelId(2156);
		h2.setHotelName("SubStar International");
		h2.setRating("4 Star");
		h2.setParent3(t1);
		h2.setParent4(t2);
		
		HotelsDTO h3 = new HotelsDTO();
		h3.setHotelId(3420);
		h3.setHotelName("Oriental Aster");
		h3.setRating("3 Star");
		h3.setParent3(t1);
		h3.setParent4(t2);
		
		Set s = new HashSet();
		s.add(c1);
		s.add(c2);

		p1.setCars(s);
		p2.setCars(s);
		

		Transaction tx = session.beginTransaction();

		session.save(p1);
		session.save(p2);
		session.save(h1);
		session.save(h2);
		session.save(h3);

		tx.commit();
		session.close();
		factory.close();

	}

}
