package com.orgchart.orgchart.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author YOG1HC
 *
 */

@Entity
public class Department {
	
	@Id
	private long id;
	private String name;
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
	
	

}
