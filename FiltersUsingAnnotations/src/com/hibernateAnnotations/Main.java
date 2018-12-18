package com.hibernateAnnotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Filter;
import org.hibernate.Query;

public class Main {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Filter filter = session.enableFilter("employeeFilter");
		filter.setParameter("salary", 4000);
		Query query = session.createQuery("from Employee101 e");
		List list = query.list();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Employee101 emp = (Employee101) it.next();
			System.out.println("Employee Name : " + emp.getEmployeeName() + " , Salary : " + emp.getSalary());
		}

	}

}
