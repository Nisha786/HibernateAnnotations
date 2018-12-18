package com.hibernateAnnotations;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "Department101")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Department101 {

	@Id
	private int id;
	private String name;

	public Department101() {
	}

	public Department101(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
