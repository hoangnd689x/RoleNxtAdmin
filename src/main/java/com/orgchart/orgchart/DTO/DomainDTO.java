package com.orgchart.orgchart.DTO;

/**
 * @author NNA7HC
 *
 */
public class DomainDTO {

	private int id;
	private String name;
	private boolean activate;
	
	public DomainDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DomainDTO(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public boolean getActivate() {
		return activate;
	}
	public void setActivate(boolean activate) {
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
}
