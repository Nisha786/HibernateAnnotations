package com.mumbaiAirport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class CreateArrivalDeparture {

	public static void main(String[] args) throws ParseException {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Terminal1DTO t1 = new Terminal1DTO();
		t1.setTerminal1Id(101);
		t1.setTerminal1Name("DomesticTerminal");
		t1.setFlights("AirIndia");

		Terminal2DTO t2 = new Terminal2DTO();
		t2.setTerminal2Id(201);
		t2.setTerminal2Name("InternationalTerminal");
		t2.setFlights("Vistara");

		ArrivalsDTO a1 = new ArrivalsDTO();
		a1.setArrivalId(63175);
		a1.setCarrier("IndiGo");
		a1.setOrigin("Bagdogra");
		a1.setArrivalDate(new SimpleDateFormat("yyyy/MM/dd").parse("2018/09/15"));
		a1.setArrivalTime(new SimpleDateFormat("HH:mm:ss").parse("09:10:00"));
		a1.setStatus("Landed");
		a1.setParent5(t1);
		a1.setParent6(t2);

		ArrivalsDTO a2 = new ArrivalsDTO();
		a2.setArrivalId(4127);
		a2.setCarrier("SpiceJet");
		a2.setOrigin("Bengaluru");
		a2.setArrivalDate(new SimpleDateFormat("yyyy/MM/dd").parse("2018/09/16"));
		a2.setArrivalTime(new SimpleDateFormat("HH:mm:ss").parse("09:25:10"));
		a2.setStatus("Delayed");
		a2.setParent5(t1);
		a2.setParent6(t2);

		DepartureDTO dp1 = new DepartureDTO();
		dp1.setDepartureId(6121);
		dp1.setCarrier("GoAir");
		dp1.setDestination("Hyderabad");
		dp1.setDepartureDate(new SimpleDateFormat("yyyy/MM/dd").parse("2018/09/21"));
		dp1.setDepartureTime(new SimpleDateFormat("HH:mm:ss").parse("15:35:30"));
		dp1.setStatus("Delayed");
		dp1.setParent3(t1);
		dp1.setParent4(t2);

		DepartureDTO dp2 = new DepartureDTO();
		dp2.setDepartureId(1455);
		dp2.setCarrier("Emirates");
		dp2.setDestination("Dubai");
		dp2.setDepartureDate(new SimpleDateFormat("yyyy/MM/dd").parse("2018/09/22"));
		dp2.setDepartureTime(new SimpleDateFormat("HH:mm:ss").parse("10:10:00"));
		dp2.setStatus("En Route");
		dp2.setParent3(t1);
		dp2.setParent4(t2);
		
		//M:1 Bidirectional for lounges and terminals
		
		LoungesDTO l1 = new LoungesDTO();
		l1.setLoungeId(2461);
		l1.setLoungeName("Aviserv Lounge");
		
		LoungesDTO l2 = new LoungesDTO();
		l2.setLoungeId(4123);
		l2.setLoungeName("Travel Club");
		
		LoungesDTO l3 = new LoungesDTO();
		l3.setLoungeId(7653);
		l3.setLoungeName("Mustang Lounge");
		
		Set s = new HashSet();
		s.add(l1);
		s.add(l2);
		s.add(l3);
		
		t1.setLounges(s);
		t2.setLounges(s);
		
		l1.setParent(t1);
		l2.setParent(t1);
		l3.setParent(t1);
		l1.setParent1(t2);
		l2.setParent1(t2);
		l3.setParent1(t2);
		
		session.save(t1);
		session.save(t2);
		session.save(a1);
		session.save(a2);
     	session.save(dp1);
    	session.save(dp2);
    	session.save(l1);
    	session.save(l2);
    	session.save(l3);
		  
		tx.commit();

		session.close();
		factory.close();
	}

}
