package com.mumbaiAirport;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mumbaiAirport.ParkingDTO;
import com.mumbaiAirport.Terminal1DTO;
import com.mumbaiAirport.HotelsDTO;
import com.mumbaiAirport.CarRentalDTO;

public class GetCarParkingData {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		Object o = session.get(ParkingDTO.class, new Integer(505));
		ParkingDTO p = (ParkingDTO) o;
		System.out.println(p.getParkingId() + "\t" + p.getParkingType());

		Set s1 = p.getCars();
		Iterator it1 = s1.iterator();

		while (it1.hasNext()) {

			Object o1 = it1.next();
			CarRentalDTO c = (CarRentalDTO) o1;

			System.out.println("---------------------------");
			System.out.println(c.getCarId() + "\t" + c.getCompany() + "\t" + c.getMobileno());
			System.out.println("---------------------------");
			System.out.println("CarRent from Parking has been selected.....!");
		}

		Query qry = session.createQuery("from HotelsDTO h");

		List l = qry.list();
		Iterator it2 = l.iterator();
		while (it2.hasNext()) {
			Object o2 = it2.next();
			HotelsDTO h = (HotelsDTO) o2;
			System.out.println(h.getHotelId() + "\t" + h.getHotelName() + "\t" + h.getRating());
			Terminal1DTO t1 = h.getParent3();
			System.out.println(t1.getTerminal1Id() + "\t" + t1.getTerminal1Name() + "\t" + t1.getFlights());
		}
		
		Query qry2 = session.createQuery("from HotelsDTO h");

		List l2 = qry2.list();
		Iterator it3 = l2.iterator();
		while (it3.hasNext()) {
			Object o3 = it3.next();
			HotelsDTO h2 = (HotelsDTO) o3;
			System.out.println(h2.getHotelId() + "\t" + h2.getHotelName() + "\t" + h2.getRating());
			Terminal2DTO t2 = h2.getParent4();
			System.out.println(t2.getTerminal2Id() + "\t" + t2.getTerminal2Name() + "\t" + t2.getFlights());
		}

		session.close();
		factory.close();
	}

}
