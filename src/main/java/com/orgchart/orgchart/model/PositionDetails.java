package com.orgchart.orgchart.model;

/**
 * @author YOG1HC
 *
 */
public class PositionDetails {
	
	private long id;
	private long positionId;
	private String roles;
	private String projects;
	private String responsibilities;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getPositionId() {
		return positionId;
	}
	public void setPositionId(long positionId) {
		this.positionId = positionId;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public String getProjects() {
		return projects;
	}
	public void setProjects(String projects) {
		this.projects = projects;
	}
	public String getResponsibilities() {
		return responsibilities;
	}
	public void setResponsibilities(String responsibilities) {
		this.responsibilities = responsibilities;
	}
	
}
