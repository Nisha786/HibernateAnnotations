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
@Table(name = "Transport")
public class TransportDTO {

	@Id
	@Column(name = "Id")
	public int id;

	@Column(name = "Name")
	public String name;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Terminal1_Id", referencedColumnName = "Terminal1Id")
	private Terminal1DTO parent1;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Terminal2_Id", referencedColumnName = "Terminal2Id")
	private Terminal2DTO parent2;

	@ManyToMany(targetEntity = ParkingDTO.class, cascade = CascadeType.ALL)
	@JoinTable(name = "Transports_Parkings", joinColumns = @JoinColumn(name = "Transport_id_fk", referencedColumnName = "Id"), inverseJoinColumns = @JoinColumn(name = "Parking_id_fk", referencedColumnName = "ParkingId"))
	private Set parkings;

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

	public Set getParkings() {
		return parkings;
	}

	public void setParkings(Set parkings) {
		this.parkings = parkings;
	}

}
