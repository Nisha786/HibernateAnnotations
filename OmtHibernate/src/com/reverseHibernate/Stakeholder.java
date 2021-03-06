package com.reverseHibernate;
// Generated Sep 14, 2018 12:08:49 PM by Hibernate Tools 5.2.3.Final

/**
 * Stakeholder generated by hbm2java
 */
public class Stakeholder implements java.io.Serializable {

	private int contactId;
	private Project project;
	private String rollName;

	public Stakeholder() {
	}

	public Stakeholder(int contactId) {
		this.contactId = contactId;
	}

	public Stakeholder(int contactId, Project project, String rollName) {
		this.contactId = contactId;
		this.project = project;
		this.rollName = rollName;
	}

	public int getContactId() {
		return this.contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getRollName() {
		return this.rollName;
	}

	public void setRollName(String rollName) {
		this.rollName = rollName;
	}

}
