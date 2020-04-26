package com.orgchart.orgchart.DTO;

/**
 * @author NNA7HC
 *
 */
public class CareerPathDTO {
	
	private long id;
	
	private String name;
	
	private String color;
	
	private boolean activate;
	
	public CareerPathDTO(long id, String name, String color, boolean activate) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.activate = activate;
	}
	public CareerPathDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public boolean getActivate() {
		return activate;
	}
	public void setActivate(boolean activate) {
		this.activate = activate;
	}
}
