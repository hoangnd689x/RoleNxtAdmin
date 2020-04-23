package com.orgchart.orgchart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DOMAIN")
public class Domain {
	
	@Id
	@Column(name = "DOMAIN_ID", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "DOMAIN_NAME")
	private String name;
	
	@Column(name = "ACTIVATE")
	private boolean activate;
	
	public Domain(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Domain() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public boolean getActivate() {
		return activate;
	}
	public void setActivate(boolean activate) {
		this.activate = activate;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
