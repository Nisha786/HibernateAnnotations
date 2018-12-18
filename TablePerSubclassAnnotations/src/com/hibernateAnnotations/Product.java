package com.hibernateAnnotations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "product")
@PrimaryKeyJoinColumn(name = "ID")
public class Product extends Customer {

	@Column(name = "productId")
	private int productId;

	@Column(name = "productName")
	private String productName;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

}
