package com.hibernateAnnotations;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Actor")
public class Actor {

	@Id
	@Column(name = "actorId")
	private int actorId;
	@Column(name = "actorName")
	private String actorName;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Did", referencedColumnName = "directorId")
	private Director parent;

	public int getActorId() {
		return actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public Director getParent() {
		return parent;
	}

	public void setParent(Director parent) {
		this.parent = parent;
	}

}
