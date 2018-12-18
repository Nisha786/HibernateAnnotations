package com.mumbaiAirport;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Hotel")
public class HotelsDTO {

	@Id
	@Column(name = "HotelId")
	public Integer hotelId;

	@Column(name = "HotelName")
	public String hotelName;

	@Column(name = "Rating")
	public String rating;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Terminal1_Id", referencedColumnName = "Terminal1Id")
	private Terminal1DTO parent3;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Terminal2_Id", referencedColumnName = "Terminal2Id")
	private Terminal2DTO parent4;

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
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
