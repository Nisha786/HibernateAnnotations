package com.mumbaiAirport;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Departure")
public class DepartureDTO {

	@Id
	@Column(name = "Id")
	public Integer departureId;

	@Column(name = "Carrier")
	public String carrier;

	@Column(name = "Destination")
	public String destination;

	@Temporal(TemporalType.DATE)
	@Column(name = "DepartureDate")
	public Date departureDate;

	@Temporal(TemporalType.TIME)
	@Column(name = "DepartureTime")
	public Date departureTime;

	@Column(name = "Status")
	public String status;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Terminal1_Id", referencedColumnName = "Terminal1Id")
	private Terminal1DTO parent3;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Terminal2_Id", referencedColumnName = "Terminal2Id")
	private Terminal2DTO parent4;

	public int getDepartureId() {
		return departureId;
	}

	public void setDepartureId(Integer departureId) {
		this.departureId = departureId;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Terminal1DTO getParent3() {
		return parent3;
	}

	public void setParent3(Terminal1DTO parent3) {
		this.parent3 = parent3;
	}

	public Terminal2DTO getParent4() {
		return parent4;
	}

	public void setParent4(Terminal2DTO parent4) {
		this.parent4 = parent4;
	}

}
