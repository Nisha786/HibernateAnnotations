package com.mumbaiAirport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mumbaiAirport.*;;

@Entity
@Table(name = "Lounges")
public class LoungesDTO {

	@Id
	@Column(name = "LoungeId")
	private Integer loungeId;

	@Column(name = "LoungeName")
	private String loungeName;

	@ManyToOne
	@JoinColumn(name = "Terminal1Id")
	private Terminal1DTO parent;

	@ManyToOne
	@JoinColumn(name = "Terminal2Id")
	private Terminal2DTO parent1;

	public Integer getLoungeId() {
		return loungeId;
	}

	public void setLoungeId(Integer loungeId) {
		this.loungeId = loungeId;
	}

	public String getLoungeName() {
		return loungeName;
	}

	public void setLoungeName(String loungeName) {
		this.loungeName = loungeName;
	}

	public Terminal1DTO getParent() {
		return parent;
	}

	public void setParent(Terminal1DTO parent) {
		this.parent = parent;
	}

	public Terminal2DTO getParent1() {
		return parent1;
	}

	public void setParent1(Terminal2DTO parent1) {
		this.parent1 = parent1;
	}
}
