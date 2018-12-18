package com.hibernateAnnotations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Mother")
public class Mother {

	@Id
	@Column(name = "motherId")
	private int motherId;

	@Column(name = "motherName", length = 11)
	private String motherName;

	public int getMotherId() {
		return motherId;
	}

	public void setMotherId(int motherId) {
		this.motherId = motherId;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

}
