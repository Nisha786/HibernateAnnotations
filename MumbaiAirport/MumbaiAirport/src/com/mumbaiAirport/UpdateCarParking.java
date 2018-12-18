package com.mumbaiAirport;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.mumbaiAirport.ParkingDTO;
import com.mumbaiAirport.CarRentalDTO;

public class UpdateCarParking {

	public static void main(String[] args) {


		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		// ManyToMany CarRental Parking
		
		Terminal1DTO t1 = new Terminal1DTO();
		t1.setTerminal1Id(101);
		t1.setTerminal1Name("DomesticTerminal");
		t1.setFlights("AirIndia");

		Terminal2DTO t2 = new Terminal2DTO();
		t2.setTerminal2Id(201);
		t2.setTerminal2Name("InternationalTerminal");
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
		c1.setCompany("Hertz");
		c1.setMobileno(26533141);
		
		CarRentalDTO c2 = new CarRentalDTO();
		c2.setCarId(2);
		c2.setCompany("Toyota Hire Rental");
		c2.setMobileno(49194242);

		Transaction tx = session.beginTransaction();
		session.update(p1);
		session.update(p2);
		session.update(c1);
		session.update(c2);
		tx.commit();
		session.close();
		System.out.println("Arrivals from Terminal1 has been updated.....!!");
		factory.close();
	}

}
