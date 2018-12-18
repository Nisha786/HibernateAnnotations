package com.mumbaiAirport;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class UpdateArrivalDeparture {

	public static void main(String[] args) throws ParseException {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();

		Terminal1DTO t1 = new Terminal1DTO();
		t1.setTerminal1Id(101);
		t1.setTerminal1Name("DomesticTerminal2");
		t1.setFlights("Air Deccan");
		
		Terminal2DTO t2 = new Terminal2DTO();
		t2.setTerminal2Id(201);
		t2.setTerminal2Name("InternationalTerminal");
		t2.setFlights("Air India Express");

		ArrivalsDTO a1 = new ArrivalsDTO();
		a1.setArrivalId(63175);
		a1.setCarrier("Kenya Airways");
		a1.setOrigin("Nairobi");
		a1.setArrivalDate(new SimpleDateFormat("yyyy/MM/dd").parse("2018/09/25"));
		a1.setArrivalTime(new SimpleDateFormat("HH:mm:ss").parse("14:30:10"));
		a1.setStatus("Landed");
		a1.setParent5(t1);
		a1.setParent6(t2);
		
		ArrivalsDTO a2 = new ArrivalsDTO();
		a2.setArrivalId(4127);
		a2.setCarrier("Delta Air Lines");
		a2.setOrigin("Goa");
		a2.setArrivalDate(new SimpleDateFormat("yyyy/MM/dd").parse("2018/10/01"));
		a2.setArrivalTime(new SimpleDateFormat("HH:mm:ss").parse("12:00:00"));
		a2.setStatus("Delayed");
		a2.setParent5(t1);
		a2.setParent6(t2);
		
		DepartureDTO dp1 = new DepartureDTO();
		dp1.setDepartureId(121);
		dp1.setCarrier("Bangkok Airways");
		dp1.setDestination("Bengaluru");
		dp1.setDepartureDate(new SimpleDateFormat("yyyy/MM/dd").parse("2018/11/20"));
		dp1.setDepartureTime(new SimpleDateFormat("HH:mm:ss").parse("20:21:30"));
		dp1.setStatus("Landed");
		dp1.setParent3(t1);
		dp1.setParent4(t2);

		DepartureDTO dp2 = new DepartureDTO();
		dp2.setDepartureId(455);
		dp2.setCarrier("Garuda Indonesia");
		dp2.setDestination("Denpasar");
		dp2.setDepartureDate(new SimpleDateFormat("yyyy/MM/dd").parse("2018/11/11"));
		dp2.setDepartureTime(new SimpleDateFormat("HH:mm:ss").parse("13:05:00"));
		dp2.setStatus("Delayed");
		dp2.setParent3(t1);
		dp2.setParent4(t2);
		
		Transaction tx = session.beginTransaction();
		session.update(t1);
		session.update(t2);
		session.update(a1);
		session.update(a2);
		session.update(dp1);
		session.update(dp2);
		
		tx.commit();
		session.close();
		System.out.println("Arrivals from Terminal1 has been updated.....!!");
		factory.close();
	}

}
