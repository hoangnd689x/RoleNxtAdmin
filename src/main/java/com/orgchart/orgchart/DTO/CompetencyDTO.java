package com.orgchart.orgchart.DTO;



public class CompetencyDTO {
	
	private int id;
	private String name;
	private String category;
	private DomainDTO dmOjb;
	private boolean activate;
	
	public CompetencyDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CompetencyDTO(int id, String name, String category, DomainDTO dmOjb, boolean activate) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.dmOjb = dmOjb;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public DomainDTO getDmOjb() {
		return dmOjb;
	}
	public void setDmOjb(DomainDTO dmOjb) {
		this.dmOjb = dmOjb;
	}
	public boolean getActivate() {
		return activate;
	}
	public void setActivate(boolean activate) {
		this.activate = activate;
	}
	
}
