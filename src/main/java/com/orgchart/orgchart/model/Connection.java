package com.orgchart.orgchart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author NNA7HC
 *
 */

@Entity
@Table(name = "CONNECTIONS")
public class Connection {
	@Id
	@Column(name = "CONNECTION_ID", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "ORGANIZATION_ID")
	private Organization orgObj;
	
	@ManyToOne
	@JoinColumn(name = "SOURCE_ID")
	private Position source;
	
	@ManyToOne
	@JoinColumn(name = "TARGET_ID")
	private Position target;
	
	@Column(name = "ACTIVATE")
	private boolean activate;

	public Connection() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Connection(long id, Organization orgObj, Position source, Position target, boolean activate) {
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

	public Organization getOrgObj() {
		return orgObj;
	}

	public void setOrgObj(Organization orgObj) {
		this.orgObj = orgObj;
	}

	public Position getSource() {
		return source;
	}

	public void setSource(Position source) {
		this.source = source;
	}

	public Position getTarget() {
		return target;
	}

	public void setTarget(Position target) {
		this.target = target;
	}

	public boolean getActivate() {
		return activate;
	}

	public void setActivate(boolean activate) {
		this.activate = activate;
	}
}
