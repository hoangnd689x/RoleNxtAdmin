package com.orgchart.orgchart.model;

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
@Table(name = "ORGANIZATIONS")
public class Organization {
	
	@Id
	@Column(name = "ORGANIZATION_ID", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "DOMAIN_ID")
	private Domain domainObj;
	
	@Column(name = "ORGANIZATION_NAME")
	private String name;
	
	@Column(name = "BUSINESS_SECTOR")
	private String businessSector;
	
	@Column(name = "ACTIVATE")
	private boolean activate;
	
	public Organization(int id, Domain domainObj, String name, String businessSector, boolean activate) {
		super();
		this.id = id;
		this.domainObj = domainObj;
		this.name = name;
		this.businessSector = businessSector;
		this.activate = activate;
	}
	public Organization() {
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
	public Domain getDomainObj() {
		return domainObj;
	}
	public void setDomainObj(Domain domainObj) {
		this.domainObj = domainObj;
	}
	public String getBusinessSector() {
		return businessSector;
	}
	public void setBusinessSector(String businessSector) {
		this.businessSector = businessSector;
	}
	
}
