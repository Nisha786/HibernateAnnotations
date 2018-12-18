package com.hibernateAnnotations;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {

	@Id
	@Column(name = "CustId")
	private int CustId;
	@Column(name = "CustName", length = 11)
	private String CustName;
	@OneToOne(targetEntity = Vendor.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "v_id", referencedColumnName = "vid")
	private Vendor parent;

	public int getCustId() {
		return CustId;
	}

	public void setCustId(int custId) {
		CustId = custId;
	}

	public String getCustName() {
		return CustName;
	}

	public void setCustName(String custName) {
		CustName = custName;
	}

	public Vendor getParent() {
		return parent;
	}

	public void setParent(Vendor parent) {
		this.parent = parent;
	}

}
