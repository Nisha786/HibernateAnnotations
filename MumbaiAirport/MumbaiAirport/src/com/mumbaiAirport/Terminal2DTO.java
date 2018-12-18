package com.mumbaiAirport;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Terminal2")
public class Terminal2DTO {

	@Id
	@Column(name = "Terminal2Id")
	public int terminal2Id;

	@Column(name = "Terminal2Name")
	public String terminal2Name;

	@Column(name = "Flights")
	public String flights;

	@OneToMany(mappedBy = "parent1", cascade = CascadeType.ALL)
	private Set<LoungesDTO> lounges;

	public int getTerminal2Id() {
		return terminal2Id;
	}

	public void setTerminal2Id(int terminal2Id) {
		this.terminal2Id = terminal2Id;
	}

	public String getTerminal2Name() {
		return terminal2Name;
	}

	public void setTerminal2Name(String terminal2Name) {
		this.terminal2Name = terminal2Name;
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
