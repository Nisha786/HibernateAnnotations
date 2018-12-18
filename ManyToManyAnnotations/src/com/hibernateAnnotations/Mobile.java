package com.hibernateAnnotations;

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
@Table(name = "Mobile")
public class Mobile {

	@Id
	@Column(name = "mobileId")
	private int mobileId;
	@Column(name = "mobileName")
	private String mobileName;
	@ManyToMany(targetEntity = Hotspot.class, cascade = CascadeType.ALL)
	@JoinTable(name = "Mobiles_hotspots", joinColumns = @JoinColumn(name = "mobile_Id_fk", referencedColumnName = "mobileId"), inverseJoinColumns = @JoinColumn(name = "hotspot_Id_fk", referencedColumnName = "hotspotId"))
	private Set hotspots;

	public int getMobileId() {
		return mobileId;
	}

	public void setMobileId(int mobileId) {
		this.mobileId = mobileId;
	}

	public String getMobileName() {
		return mobileName;
	}

	public void setMobileName(String mobileName) {
		this.mobileName = mobileName;
	}

	public Set getHotspots() {
		return hotspots;
	}

	public void setHotspots(Set hotspots) {
		this.hotspots = hotspots;
	}

}
