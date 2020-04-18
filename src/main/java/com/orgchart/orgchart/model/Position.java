package com.orgchart.orgchart.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author YOG1HC
 *
 */
public class Position implements Serializable{
	
	private long id;
	private long organization;
	private String name;
	
	private Organization organizationObj;
	
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
	public long getOrganization() {
		return organization;
	}
	public void setOrganization(long organization) {
		this.organization = organization;
	}
	public Organization getOrganizationObj() {
		return organizationObj;
	}
	public void setOrganizationObj(Organization organizationObj) {
		this.organizationObj = organizationObj;
	}
	
}
