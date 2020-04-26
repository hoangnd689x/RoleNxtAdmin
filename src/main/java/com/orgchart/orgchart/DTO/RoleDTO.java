package com.orgchart.orgchart.DTO;

import java.util.List;

/**
 * @author NNA7HC
 *
 */

public class RoleDTO {
	private int id;
	private PositionDTO positionObj;
	private CareerPathDTO careerPath;
	private List<CompetencyDTO> competencies;
	private String domainRole;
	private String category;
	private String KRA;
	private String scope;
	private String responsibilities;
	private String industrialRole;
	private String entryCriteria;
	private boolean activate;

	public RoleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoleDTO(int id, CareerPathDTO careerPath, PositionDTO positionObj, String domainRole, String category, String kRA,
			String scope, String responsibilities, String industrialRole, String entryCriteria, boolean activate) {
		super();
		this.id = id;
		this.careerPath = careerPath;
		this.positionObj = positionObj;
		this.domainRole = domainRole;
		this.category = category;
		KRA = kRA;
		this.scope = scope;
		this.responsibilities = responsibilities;
		this.industrialRole = industrialRole;
		this.entryCriteria = entryCriteria;
		this.activate = activate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CareerPathDTO getCareerPath() {
		return careerPath;
	}

	public void setCareerPath(CareerPathDTO careerPath) {
		this.careerPath = careerPath;
	}

	public PositionDTO getPositionObj() {
		return positionObj;
	}

	public void setPositionObj(PositionDTO positionObj) {
		this.positionObj = positionObj;
	}

	public List<CompetencyDTO> getCompetencies() {
		return competencies;
	}

	public void setCompetencies(List<CompetencyDTO> competencies) {
		this.competencies = competencies;
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

	public boolean getActivate() {
		return activate;
	}

	public void setActivate(boolean activate) {
		this.activate = activate;
	}

}
