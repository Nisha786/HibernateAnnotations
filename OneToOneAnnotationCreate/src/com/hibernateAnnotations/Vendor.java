package com.hibernateAnnotations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Vendor")
public class Vendor {

	@Id
	@Column(name = "Vid")
	private int Vid;
	@Column(name = "Vname")
	private String Vname;

	public int getVid() {
		return Vid;
	}

	public void setVid(int vid) {
		Vid = vid;
	}

	public String getVname() {
		return Vname;
	}

	public void setVname(String vname) {
		Vname = vname;
	}

}
