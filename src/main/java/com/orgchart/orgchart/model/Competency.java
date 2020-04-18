package com.orgchart.orgchart.model;

public class Competency {
	
	private long id;
	private String name;
	
	private String category;
	private long dm;
	private Domain dmOjb;
	
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public long getDm() {
		return dm;
	}
	public void setDm(long dm) {
		this.dm = dm;
	}
	public Domain getDmOjb() {
		return dmOjb;
	}
	public void setDmOjb(Domain dmOjb) {
		this.dmOjb = dmOjb;
	}
	
}
