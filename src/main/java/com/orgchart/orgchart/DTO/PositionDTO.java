package com.orgchart.orgchart.DTO;


import com.orgchart.orgchart.model.CareerPath;
import com.orgchart.orgchart.model.Organization;

/**
 * @author NNA7HC
 *
 */

public class PositionDTO {

	private int id;
	
	private OrganizationDTO organizationObj;
	
	private CareerPathDTO careerpathObj;
	private String name;
	private int cluster;
	private boolean activate;

	public PositionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PositionDTO(int id, OrganizationDTO organizationObj, CareerPathDTO careerpathObj, String name, int cluster,
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

	public OrganizationDTO getOrganizationObj() {
		return organizationObj;
	}

	public void setOrganizationObj(OrganizationDTO organizationObj) {
		this.organizationObj = organizationObj;
	}

	public CareerPathDTO getCareerpathObj() {
		return careerpathObj;
	}

	public void setCareerpathObj(CareerPathDTO careerpathObj) {
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
