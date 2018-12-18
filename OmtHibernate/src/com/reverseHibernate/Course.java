package com.reverseHibernate;
// Generated Sep 14, 2018 12:08:49 PM by Hibernate Tools 5.2.3.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Course generated by hbm2java
 */
public class Course implements java.io.Serializable {

	private int cid;
	private String cname;
	private Set lectures = new HashSet(0);

	public Course() {
	}

	public Course(int cid) {
		this.cid = cid;
	}

	public Course(int cid, String cname, Set lectures) {
		this.cid = cid;
		this.cname = cname;
		this.lectures = lectures;
	}

	public int getCid() {
		return this.cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Set getLectures() {
		return this.lectures;
	}

	public void setLectures(Set lectures) {
		this.lectures = lectures;
	}

}
