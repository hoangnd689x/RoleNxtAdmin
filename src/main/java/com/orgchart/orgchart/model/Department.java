package com.orgchart.orgchart.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author YOG1HC
 *
 */

@Entity
public class Department {
	
	@Id
	private long id;
	private String name;
	private String domain;
	private String businessSector;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getBusinessSector() {
		return businessSector;
	}
	public void setBusinessSector(String businessSector) {
		this.businessSector = businessSector;
	}
	
}
