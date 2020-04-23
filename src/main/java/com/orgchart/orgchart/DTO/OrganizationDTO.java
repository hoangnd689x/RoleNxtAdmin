package com.orgchart.orgchart.DTO;


/**
 * @author NNA7HC
 *
 */
public class OrganizationDTO {
	private int id;
	private DomainDTO domainObj;
	private String name;
	private String businessSector;
	private boolean activate;
	
	
	public OrganizationDTO(int id, DomainDTO domainObj, String name, String businessSector, boolean activate) {
		super();
		this.id = id;
		this.domainObj = domainObj;
		this.name = name;
		this.businessSector = businessSector;
		this.activate = activate;
	}
	public OrganizationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public DomainDTO getDomainObj() {
		return domainObj;
	}
	public void setDomainObj(DomainDTO domainObj) {
		this.domainObj = domainObj;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBusinessSector() {
		return businessSector;
	}
	public void setBusinessSector(String businessSector) {
		this.businessSector = businessSector;
	}
	public boolean getActivate() {
		return activate;
	}
	public void setActivate(boolean activate) {
		this.activate = activate;
	}
	
	
}
