package com.hibernateAnnotations;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "University")
public class UniversityDTO {

	@Id
	@GeneratedValue
	@Column(name = "UId")
	public Long id;

	@Column(name = "Name")
	public String name;

	@Column(name = "Country")
	public String country;

	@OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
	private Set<StudentDTO> students;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Set<StudentDTO> getStudents() {
		return students;
	}

	public void setStudents(Set<StudentDTO> students) {
		this.students = students;
	}

}
