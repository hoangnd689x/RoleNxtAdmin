package com.orgchart.orgchart.model;

import java.util.List;

public class Role {
	
	private long id;
	private long domain;
	private Domain domainObj;
	private String careerPath;
	private long position;
	private Position positionObj;
	private String domainRole;
	private String category;
	private String competency;
	private List<Competency> competencyObj;
	private String KRA;
	private String scope;
	private String responsibilities;
	private String industrialRle;
	private String entryCriteria;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getCareerPath() {
		return careerPath;
	}
	public void setCareerPath(String careerPath) {
		this.careerPath = careerPath;
	}
	public long getPosition() {
		return position;
	}
	public void setPosition(long position) {
		this.position = position;
	}
	public Position getPositionObj() {
		return positionObj;
	}
	public void setPositionObj(Position positionObj) {
		this.positionObj = positionObj;
	}
	public String getDomainRole() {
		return domainRole;
	}
	public void setDomainRole(String domainRole) {
		this.domainRole = domainRole;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCompetency() {
		return competency;
	}
	public void setCompetency(String competency) {
		this.competency = competency;
	}
	public List<Competency> getCompetencyObj() {
		return competencyObj;
	}
	public void setCompetencyObj(List<Competency> competencyObj) {
		this.competencyObj = competencyObj;
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
	public String getIndustrialRle() {
		return industrialRle;
	}
	public void setIndustrialRle(String industrialRle) {
		this.industrialRle = industrialRle;
	}
	public String getEntryCriteria() {
		return entryCriteria;
	}
	public void setEntryCriteria(String entryCriteria) {
		this.entryCriteria = entryCriteria;
	}

}
