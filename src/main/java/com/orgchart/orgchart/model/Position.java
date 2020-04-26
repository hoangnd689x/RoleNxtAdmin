package com.orgchart.orgchart.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author NNA7HC
 *
 */
@Entity
@Table(name = "POSITIONS")
public class Position implements Serializable{
	
	@Id
	@Column(name = "POSITION_ID", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "ORGANIZATION_ID")
	private Organization organizationObj;
	
	@ManyToOne
	@JoinColumn(name = "CP_ID")
	private CareerPath careerpathObj;
	
	@Column(name = "POSITION_NAME")
	private String name;
	
	@Column(name = "CLUSTER")
	private int cluster;
	
	@Column(name = "ACTIVATE")
	private boolean activate;

	public Position() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Position(int id, Organization organizationObj, CareerPath careerpathObj, String name, int cluster,
			boolean activate) {
		super();
		this.id = id;
		this.organizationObj = organizationObj;
		this.careerpathObj = careerpathObj;
		this.name = name;
		this.cluster = cluster;
		this.activate = activate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Organization getOrganizationObj() {
		return organizationObj;
	}

	public void setOrganizationObj(Organization organizationObj) {
		this.organizationObj = organizationObj;
	}

	public CareerPath getCareerpathObj() {
		return careerpathObj;
	}

	public void setCareerpathObj(CareerPath careerpathObj) {
		this.careerpathObj = careerpathObj;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCluster() {
		return cluster;
	}

	public void setCluster(int cluster) {
		this.cluster = cluster;
	}

	public boolean getActivate() {
		return activate;
	}

	public void setActivate(boolean activate) {
		this.activate = activate;
	}
	
}
