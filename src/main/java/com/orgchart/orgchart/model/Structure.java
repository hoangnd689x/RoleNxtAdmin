package com.orgchart.orgchart.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author YOG1HC
 *
 */
@Entity
public class Structure  implements Serializable{

	@Id
	private long id;
	private String path;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
	
}
