package com.reverseHibernate;
// Generated Sep 14, 2018 10:55:54 AM by Hibernate Tools 5.2.3.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Address generated by hbm2java
 */
public class Address implements java.io.Serializable {

	private Integer id;
	private String address;
	private String city;
	private String state;
	private Set students = new HashSet(0);

	public Address() {
	}

	public Address(String address, String city, String state, Set students) {
		this.address = address;
		this.city = city;
		this.state = state;
		this.students = students;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Set getStudents() {
		return this.students;
	}

	public void setStudents(Set students) {
		this.students = students;
	}

}
