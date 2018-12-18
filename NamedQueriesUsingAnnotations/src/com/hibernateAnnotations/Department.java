package com.hibernateAnnotations;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({ @NamedQuery(

		name = "findDepartmentByName",
		// query = "from Department"
	    //query = "from Department where firstName like :firstName"
	    //query = "from Department where firstName = :firstName and lastName = :lastName"
	    //query = "from Department order by salary desc"
		//query ="from Department where firstName = :firstName or lastName = :lastName"
		query = "select count(id), salary from Department group by salary"
		) })
@Entity
@Table(name = "Department")
public class Department {

	public String toString() {
		return id + "\t" + firstName + "\t" + lastName + "\t" + salary;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String firstName;
	String lastName;
	int salary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

}
