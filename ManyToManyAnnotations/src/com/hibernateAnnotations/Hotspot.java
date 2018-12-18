package com.hibernateAnnotations;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Hotspot")
public class Hotspot {

	@Id
	@Column(name = "hotspotId")
	private int hotspotId;
	@Column(name = "hotspotName")
	private String hotspotName;
	@ManyToMany(targetEntity = Mobile.class, mappedBy = "hotspots")
	private Set mobiles;

	public int getHotspotId() {
		return hotspotId;
	}

	public void setHotspotId(int hotspotId) {
		this.hotspotId = hotspotId;
	}

	public String getHotspotName() {
		return hotspotName;
	}

	public void setHotspotName(String hotspotName) {
		this.hotspotName = hotspotName;
	}

	public Set getMobiles() {
		return mobiles;
	}

	public void setMobiles(Set mobiles) {
		this.mobiles = mobiles;
	}

}
