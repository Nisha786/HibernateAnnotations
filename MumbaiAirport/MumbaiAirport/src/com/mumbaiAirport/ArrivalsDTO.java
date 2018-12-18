package com.mumbaiAirport;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Arrival")
public class ArrivalsDTO {

	@Id
	@Column(name = "Id")
	public Integer arrivalId;

	@Column(name = "Carrier")
	public String carrier;

	@Column(name = "Origin")
	public String origin;

	@Temporal(TemporalType.DATE)
	@Column(name = "ArrivalDate")
	public Date arrivalDate;

	@Temporal(TemporalType.TIME)
	@Column(name = "ArrivalTime")
	public Date arrivalTime;

	@Column(name = "Status")
	public String status;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Terminal1_Id", referencedColumnName = "Terminal1Id")
	private Terminal1DTO parent5;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Terminal2_Id", referencedColumnName = "Terminal2Id")
	private Terminal2DTO parent6;

	public Integer getArrivalId() {
		return arrivalId;
	}

	public void setArrivalId(Integer arrivalId) {
		this.arrivalId = arrivalId;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Terminal1DTO getParent5() {
		return parent5;
	}

	public void setParent5(Terminal1DTO parent5) {
		this.parent5 = parent5;
	}

	public Terminal2DTO getParent6() {
		return parent6;
	}

	public void setParent6(Terminal2DTO parent6) {
		this.parent6 = parent6;
	}

}
