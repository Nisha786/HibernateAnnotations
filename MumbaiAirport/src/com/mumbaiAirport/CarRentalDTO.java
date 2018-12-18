package com.mumbaiAirport;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CarRental")
public class CarRentalDTO {

	@Id
	@Column(name = "CarId")
	public Integer carId;

	@Column(name = "Company")
	public String company;

	@Column(name = "MobileNo", length = 20)
	public Integer mobileno;

	@ManyToMany(targetEntity = ParkingDTO.class, cascade = CascadeType.ALL)
	@JoinTable(name = "Cars_Parkings", joinColumns = @JoinColumn(name = "Car_id_fk", referencedColumnName = "CarId"), inverseJoinColumns = @JoinColumn(name = "Par_id_fk", referencedColumnName = "ParkingId"))
	private Set Parkings1;

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Integer getMobileno() {
		return mobileno;
	}

	public void setMobileno(Integer mobileno) {
		this.mobileno = mobileno;
	}

	public Set getParkings1() {
		return Parkings1;
	}

	public void setParkings1(Set parkings1) {
		Parkings1 = parkings1;
	}

}
