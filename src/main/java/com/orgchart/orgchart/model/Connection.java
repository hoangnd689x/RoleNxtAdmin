package com.orgchart.orgchart.model;

public class Connection {
	
	private long id;
	private long source;
	private long target;
	private long orgID;
	
	Organization orgObj;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getSource() {
		return source;
	}
	public void setSource(long source) {
		this.source = source;
	}
	public long getTarget() {
		return target;
	}
	public void setTarget(long target) {
		this.target = target;
	}
	public long getOrgID() {
		return orgID;
	}
	public void setOrgID(long orgID) {
		this.orgID = orgID;
	}
	public Organization getOrgObj() {
		return orgObj;
	}
	public void setOrgObj(Organization orgObj) {
		this.orgObj = orgObj;
	}

}
