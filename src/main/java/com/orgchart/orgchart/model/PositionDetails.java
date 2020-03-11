package com.orgchart.orgchart.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author YOG1HC
 *
 */
@Entity
public class PositionDetails {
	
	@Id
	private String domain;
	private String careerPath;
	private String position;
	private String domainRoles;
	private String projectCategory;
	private String competencyRequires;
	private String KRA;
	private String scope;
	private String responsibilities;
	private String industrialRole;
	private String entryCriteria;
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getCareerPath() {
		return careerPath;
	}
	public void setCareerPath(String careerPath) {
		this.careerPath = careerPath;
	}
	public String getDomainRoles() {
		return domainRoles;
	}
	public void setDomainRoles(String domainRoles) {
		this.domainRoles = domainRoles;
	}
	public String getProjectCategory() {
		return projectCategory;
	}
	public void setProjectCategory(String projectCategory) {
		this.projectCategory = projectCategory;
	}
	public String getCompetencyRequires() {
		return competencyRequires;
	}
	public void setCompetencyRequires(String competencyRequires) {
		this.competencyRequires = competencyRequires;
	}
	public String getKRA() {
		return KRA;
	}
	public void setKRA(String kRA) {
		KRA = kRA;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String getResponsibilities() {
		return responsibilities;
	}
	public void setResponsibilities(String responsibilities) {
		this.responsibilities = responsibilities;
	}
	public String getIndustrialRole() {
		return industrialRole;
	}
	public void setIndustrialRole(String industrialRole) {
		this.industrialRole = industrialRole;
	}
	public String getEntryCriteria() {
		return entryCriteria;
	}
	public void setEntryCriteria(String entryCriteria) {
		this.entryCriteria = entryCriteria;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
}
