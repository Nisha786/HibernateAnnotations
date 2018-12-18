package com.hibernateAnnotations;

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
@Table(name = "Children")
public class Children {

	@Id
	@Column(name = "childrenId")
	private int childrenId;

	@Column(name = "childrenName", length = 11)
	private String childrenName;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = Mother.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "childrenId", referencedColumnName = "childrenId")

	private Set children;

	public int getChildrenId() {
		return childrenId;
	}

	public void setChildrenId(int childrenId) {
		this.childrenId = childrenId;
	}

	public String getChildrenName() {
		return childrenName;
	}

	public void setChildrenName(String childrenName) {
		this.childrenName = childrenName;
	}

	public Set getChildren() {
		return children;
	}

	public void setChildren(Set children) {
		this.children = children;
	}

}
