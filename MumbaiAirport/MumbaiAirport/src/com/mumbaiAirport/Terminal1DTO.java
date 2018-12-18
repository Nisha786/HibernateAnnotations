package com.mumbaiAirport;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Terminal1")
public class Terminal1DTO {

	@Id
	@Column(name = "Terminal1Id")
	public Integer terminal1Id;

	@Column(name = "Terminal1Name")
	public String terminal1Name;

	@Column(name = "Flights")
	public String flights;

	@OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
	private Set<LoungesDTO> lounges;

	public Integer getTerminal1Id() {
		return terminal1Id;
	}

	public void setTerminal1Id(Integer terminal1Id) {
		this.terminal1Id = terminal1Id;
	}

	public String getTerminal1Name() {
		return terminal1Name;
	}

	public void setTerminal1Name(String terminal1Name) {
		this.terminal1Name = terminal1Name;
	}

	public String getFlights() {
		return flights;
	}

	public void setFlights(String flights) {
		this.flights = flights;
	}

	public Set<LoungesDTO> getLounges() {
		return lounges;
	}

	public void setLounges(Set<LoungesDTO> lounges) {
		this.lounges = lounges;
	}
}
