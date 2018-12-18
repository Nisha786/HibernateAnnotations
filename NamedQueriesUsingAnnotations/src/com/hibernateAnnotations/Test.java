package com.hibernateAnnotations;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public void like(Session session) {

		Department d;
		Query qry = session.getNamedQuery("findDepartmentByName");
		qry.setParameter("firstName", new String("n%"));
		List l = qry.list();
		Iterator it = l.iterator();

		while (it.hasNext()) {
			d = (Department) it.next();
			System.out.println(d.getId() + "\t" + d.getFirstName() + "\t" + d.getLastName() + "\t" + d.getSalary());
		}
	}

	public void and(Session session) {
		Department d;
		Query qry = session.getNamedQuery("findDepartmentByName");
		qry.setParameter("firstName", new String("Sahil"));
		qry.setParameter("lastName", new String("Kothari"));

		List l = qry.list();
		Iterator it = l.iterator();

		while (it.hasNext()) {
			d = (Department) it.next();
			System.out.println(d.getId() + "\t" + d.getFirstName() + "\t" + d.getLastName() + "\t" + d.getSalary());
		}
	}

	public void orderBy(Session session) {

		Department d;
		Query qry = session.getNamedQuery("findDepartmentByName");

		List l = qry.list();
		Iterator it = l.iterator();

		while (it.hasNext()) {
			d = (Department) it.next();
			System.out.println(d.getId() + "\t" + d.getFirstName() + "\t" + d.getLastName() + "\t" + d.getSalary());
		}
	}

	public void or(Session session) {
		Department d;
		Query qry = session.getNamedQuery("findDepartmentByName");
		qry.setParameter("firstName", new String("Sahil"));
		qry.setParameter("lastName", new String("Ansari"));
		List l = qry.list();
		Iterator it = l.iterator();

		while (it.hasNext()) {
			d = (Department) it.next();
			System.out.println(d.getId() + "\t" + d.getFirstName() + "\t" + d.getLastName() + "\t" + d.getSalary());
		}
	}
	public void groupBy(Session session){
		
		Query qry = session.getNamedQuery("findDepartmentByName");
		List l = qry.list();
		Iterator it = l.iterator();
		
		while(it.hasNext()){
			Object[] o;
			o = (Object[]) it.next();
			Integer Id = (Integer)o[0];
			String firstName = (String)o[1];
			String lastName = (String)o[2];
			Integer salary = (Integer)o[3];
			System.out.println(Id + "\t" + firstName + "\t" + lastName + "\t" + salary);
		}
	}

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Test t = new Test();

		// t.like(session);
		// t.and(session);
		//t.orderBy(session);
		//t.or(session);
		t.groupBy(session);
		session.close();
		factory.close();
	}

}
