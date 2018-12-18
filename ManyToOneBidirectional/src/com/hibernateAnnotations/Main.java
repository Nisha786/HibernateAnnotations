package com.hibernateAnnotations;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		UniversityDTO u = new UniversityDTO();
        u.setId((long) 1);
		u.setName("CAMBRIDGE");
		u.setCountry("ENGLAND");		

		StudentDTO s1 = new StudentDTO();
		s1.setId(1);
		s1.setFirstName("Sam");
		s1.setLastName("Disilva");
		s1.setSection("Maths");
		
		StudentDTO s2 = new StudentDTO();
		s2.setId(2);
		s2.setFirstName("Joshua");
		s2.setLastName("Brill");
		s2.setSection("Science");
		
		StudentDTO s3 = new StudentDTO();
		s3.setId(3);
		s3.setFirstName("Peter");
		s3.setLastName("Pan");
		s3.setSection("Physics");
				
		// one-to-many
		Set s = new HashSet();

		s.add(s1);
		s.add(s2);
		s.add(s3);

		u.setStudents(s); 

		// many-to-one

		s1.setParent(u);
		s2.setParent(u);
		s3.setParent(u);  
		
		Transaction tx = session.beginTransaction();

		session.save(s1);
		session.save(s2);
		session.save(s3);
	    session.save(u);

		tx.commit();

		session.close();
		System.out.println("One To Many Bi-Directional is Done..!!");
		factory.close();
	}

}
