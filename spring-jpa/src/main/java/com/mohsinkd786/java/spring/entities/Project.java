package com.mohsinkd786.java.spring.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "projects")
public class Project {

	@Id
	private int p_id;
	private String description;
	private int org_id;

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getOrg_id() {
		return org_id;
	}

	public void setOrg_id(int org_id) {
		this.org_id = org_id;
	}

}
