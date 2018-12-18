package com.reverseHibernate;
// Generated Sep 14, 2018 12:08:49 PM by Hibernate Tools 5.2.3.Final

/**
 * Car generated by hbm2java
 */
public class Car implements java.io.Serializable {

	private int carId;
	private Owner ownerByOwnerDummy;
	private Owner ownerByForevenId;
	private String carName;

	public Car() {
	}

	public Car(int carId) {
		this.carId = carId;
	}

	public Car(int carId, Owner ownerByOwnerDummy, Owner ownerByForevenId, String carName) {
		this.carId = carId;
		this.ownerByOwnerDummy = ownerByOwnerDummy;
		this.ownerByForevenId = ownerByForevenId;
		this.carName = carName;
	}

	public int getCarId() {
		return this.carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public Owner getOwnerByOwnerDummy() {
		return this.ownerByOwnerDummy;
	}

	public void setOwnerByOwnerDummy(Owner ownerByOwnerDummy) {
		this.ownerByOwnerDummy = ownerByOwnerDummy;
	}

	public Owner getOwnerByForevenId() {
		return this.ownerByForevenId;
	}

	public void setOwnerByForevenId(Owner ownerByForevenId) {
		this.ownerByForevenId = ownerByForevenId;
	}

	public String getCarName() {
		return this.carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

}
