package com.mumbaiAirport;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Parking")
public class ParkingDTO {

	@Id
	@Column(name = "ParkingId")
	public Integer parkingId;

	@Column(name = "ParkingType")
	public String parkingType;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Terminal1_id", referencedColumnName = "Terminal1Id")
	private Terminal1DTO parent1;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Terminal2_id", referencedColumnName = "Terminal2Id")
	private Terminal2DTO parent2;

	@ManyToMany(targetEntity = TransportDTO.class, cascade = CascadeType.ALL)
	@JoinTable(name = "Transports_Parkings", joinColumns = @JoinColumn(name = "Parking_id_fk", referencedColumnName = "ParkingId"), inverseJoinColumns = @JoinColumn(name = "Transport_id_fk", referencedColumnName = "Id"))
	private Set Transports;

	@ManyToMany(targetEntity = CarRentalDTO.class, cascade = CascadeType.ALL)
	@JoinTable(name = "Cars_Parkings", joinColumns = @JoinColumn(name = "Par_id_fk", referencedColumnName = "ParkingId"), inverseJoinColumns = @JoinColumn(name = "Car_id_fk", referencedColumnName = "CarId"))
	private Set Cars;

	public Integer getParkingId() {
		return parkingId;
	}

	public void setParkingId(Integer parkingId) {
		this.parkingId = parkingId;
	}

	public String getParkingType() {
		return parkingType;
	}

	public void setParkingType(String parkingType) {
		this.parkingType = parkingType;
	}

	public Terminal1DTO getParent1() {
		return parent1;
	}

	public void setParent1(Terminal1DTO parent1) {
		this.parent1 = parent1;
	}

	public Terminal2DTO getParent2() {
		return parent2;
	}

	public void setParent2(Terminal2DTO parent2) {
		this.parent2 = parent2;
	}

	public Set getTransports() {
		return Transports;
	}

	public void setTransports(Set transports) {
		Transports = transports;
	}

	public Set getCars() {
		return Cars;
	}

	public void setCars(Set cars) {
		Cars = cars;
	}

}
