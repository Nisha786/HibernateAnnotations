package com.reverseHibernate;
// Generated Sep 14, 2018 12:08:49 PM by Hibernate Tools 5.2.3.Final

/**
 * Electroniccomponent generated by hbm2java
 */
public class Electroniccomponent implements java.io.Serializable {

	private int eid;
	private String ename;

	public Electroniccomponent() {
	}

	public Electroniccomponent(int eid) {
		this.eid = eid;
	}

	public Electroniccomponent(int eid, String ename) {
		this.eid = eid;
		this.ename = ename;
	}

	public int getEid() {
		return this.eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return this.ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

}
