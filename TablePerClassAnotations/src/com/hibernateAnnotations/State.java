package com.hibernateAnnotations;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("state")
public class State extends Country {

	@Column(name = "state_type")
	private String state_type;
	@Column(name = "stateName")
	private String stateName;

	public String getState_type() {
		return state_type;
	}

	public void setState_type(String state_type) {
		this.state_type = state_type;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

}
