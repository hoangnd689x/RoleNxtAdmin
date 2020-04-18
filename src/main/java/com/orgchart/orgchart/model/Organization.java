package com.orgchart.orgchart.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author YOG1HC
 *
 */

public class Organization {
	
	private long id;
	private String name;
	private long domain;
	private String businessSector;
	
	private Domain domainObj;
	
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

	public long getDomain() {
		return domain;
	}
	public void setDomain(long domain) {
		this.domain = domain;
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
