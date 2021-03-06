package com.reverseHibernate;
// Generated Sep 14, 2018 12:08:49 PM by Hibernate Tools 5.2.3.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Owner generated by hbm2java
 */
public class Owner implements java.io.Serializable {

	private int ownerId;
	private String ownerName;
	private Set carsForOwnerDummy = new HashSet(0);
	private Set carsForForevenId = new HashSet(0);

	public Owner() {
	}

	public Owner(int ownerId) {
		this.ownerId = ownerId;
	}

	public Owner(int ownerId, String ownerName, Set carsForOwnerDummy, Set carsForForevenId) {
		this.ownerId = ownerId;
		this.ownerName = ownerName;
		this.carsForOwnerDummy = carsForOwnerDummy;
		this.carsForForevenId = carsForForevenId;
	}

	public int getOwnerId() {
		return this.ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getOwnerName() {
		return this.ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public Set getCarsForOwnerDummy() {
		return this.carsForOwnerDummy;
	}

	public void setCarsForOwnerDummy(Set carsForOwnerDummy) {
		this.carsForOwnerDummy = carsForOwnerDummy;
	}

	public Set getCarsForForevenId() {
		return this.carsForForevenId;
	}

	public void setCarsForForevenId(Set carsForForevenId) {
		this.carsForForevenId = carsForForevenId;
	}

}
