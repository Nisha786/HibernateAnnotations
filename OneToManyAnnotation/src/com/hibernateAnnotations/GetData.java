package com.hibernateAnnotations;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetData {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		Object o = session.get(Children.class, new Integer(100));
		Children c = (Children) o;
		System.out.println(c.getChildrenId() + "\t" + c.getChildrenName());

		Set s = c.getChildren();
		Iterator it = s.iterator();

		while (it.hasNext()) {

			Object o1 = it.next();
			Mother m = (Mother) o1;

			System.out.println("---------------------------");
			System.out.println(m.getMotherId() + "\t" + m.getMotherName());
			System.out.println("---------------------------");
		}

		session.close();
		System.out.println("One To Many is Done for selecting.....!");
		factory.close();
	}

}
