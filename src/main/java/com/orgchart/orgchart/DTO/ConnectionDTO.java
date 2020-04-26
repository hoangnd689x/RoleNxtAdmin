package com.orgchart.orgchart.DTO;

/**
 * @author NNA7HC
 *
 */

public class ConnectionDTO {
	
	private long id;
	private OrganizationDTO orgObj;
	private PositionDTO source;
	private PositionDTO target;
	private boolean activate;

	public ConnectionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ConnectionDTO(long id, OrganizationDTO orgObj, PositionDTO source, PositionDTO target, boolean activate) {
		super();
		this.id = id;
		this.orgObj = orgObj;
		this.source = source;
		this.target = target;
		this.activate = activate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public OrganizationDTO getOrgObj() {
		return orgObj;
	}

	public void setOrgObj(OrganizationDTO orgObj) {
		this.orgObj = orgObj;
	}

	public PositionDTO getSource() {
		return source;
	}

	public void setSource(PositionDTO source) {
		this.source = source;
	}

	public PositionDTO getTarget() {
		return target;
	}

	public void setTarget(PositionDTO target) {
		this.target = target;
	}

	public boolean getActivate() {
		return activate;
	}

	public void setActivate(boolean activate) {
		this.activate = activate;
	}
}
