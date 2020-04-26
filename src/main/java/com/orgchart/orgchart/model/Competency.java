package com.orgchart.orgchart.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author NNA7HC
 *
 */
@Entity
@Table(name = "COMPETENCY")
public class Competency {
	
	@Id
	@Column(name = "COM_ID", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "COM_NAME")
	private String name;
	
	@Column(name = "CATEGORY")
	private String category;
	
	@ManyToOne
	@JoinColumn(name = "DOMAIN_ID")
	private Domain dmOjb;
	
	@ManyToMany(mappedBy = "competencies")
	private List<Role> roles;
	
	@Column(name = "ACTIVATE")
	private boolean activate;
	
	public Competency(int id, String name, String category, Domain dmOjb, boolean activate) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.dmOjb = dmOjb;
		this.activate = activate;
	}
	
	public Competency() {
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Domain getDmOjb() {
		return dmOjb;
	}
	public void setDmOjb(Domain dmOjb) {
		this.dmOjb = dmOjb;
	}
	
}
