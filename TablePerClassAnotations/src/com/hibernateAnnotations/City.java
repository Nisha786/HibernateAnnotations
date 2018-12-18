package com.hibernateAnnotations;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("city")
public class City extends Country {

	@Column(name = "city_type")
	private String city_type;
	@Column(name = "cityName")
	private String cityName;

	public String getCity_type() {
		return city_type;
	}

	public void setCity_type(String city_type) {
		this.city_type = city_type;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

}
