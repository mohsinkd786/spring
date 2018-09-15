package com.mohsinkd786.java.spring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "employs")
public class Employ {
	public Employ() {

	}

	@Id
	private int emp_id;
	@Column(name = "name")
	private String name;
	private String email;
	private int p_id;
	private int salary;

	public int getId() {
		return emp_id;
	}

	public void setId(int id) {
		this.emp_id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Employ(int id, String name, String email, int p_id, int salary) {
		this.emp_id = id;
		this.name = name;
		this.email = email;
		this.p_id = p_id;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employ [id=" + emp_id + ", name=" + name + ", email=" + email + ", p_id=" + p_id + ", salary=" + salary
				+ "]";
	}

}
