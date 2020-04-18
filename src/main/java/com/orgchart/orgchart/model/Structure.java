package com.orgchart.orgchart.model;

import java.io.Serializable;

/**
 * @author YOG1HC
 *
 */
public class Structure  implements Serializable{

	private long id;
	private long org;
	private long dm;
	private long level0;
	private long level1;
	private long level2;
	private long level3;
	private long level4;
	private long level5;
	private long level6;
	private long level7;
	
	private Organization orgObj;
	private Domain dmObj;
	private Position level0Obj;
	private Position level1Obj;
	private Position level2Obj;
	private Position level3Obj;
	private Position level4Obj;
	private Position level5Obj;
	private Position level6Obj;
	private Position level7Obj;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getOrg() {
		return org;
	}
	public void setOrg(long org) {
		this.org = org;
	}
	public long getDm() {
		return dm;
	}
	public void setDm(long dm) {
		this.dm = dm;
	}
	public long getLevel0() {
		return level0;
	}
	public void setLevel0(long level0) {
		this.level0 = level0;
	}
	public long getLevel1() {
		return level1;
	}
	public void setLevel1(long level1) {
		this.level1 = level1;
	}
	public long getLevel2() {
		return level2;
	}
	public void setLevel2(long level2) {
		this.level2 = level2;
	}
	public long getLevel3() {
		return level3;
	}
	public void setLevel3(long level3) {
		this.level3 = level3;
	}
	public long getLevel4() {
		return level4;
	}
	public void setLevel4(long level4) {
		this.level4 = level4;
	}
	public long getLevel5() {
		return level5;
	}
	public void setLevel5(long level5) {
		this.level5 = level5;
	}
	public long getLevel6() {
		return level6;
	}
	public void setLevel6(long level6) {
		this.level6 = level6;
	}
	public long getLevel7() {
		return level7;
	}
	public void setLevel7(long level7) {
		this.level7 = level7;
	}
	public Organization getOrgObj() {
		return orgObj;
	}
	public void setOrgObj(Organization orgObj) {
		this.orgObj = orgObj;
	}
	public Domain getDmObj() {
		return dmObj;
	}
	public void setDmObj(Domain dmObj) {
		this.dmObj = dmObj;
	}
	public Position getLevel0Obj() {
		return level0Obj;
	}
	public void setLevel0Obj(Position level0Obj) {
		this.level0Obj = level0Obj;
	}
	public Position getLevel1Obj() {
		return level1Obj;
	}
	public void setLevel1Obj(Position level1Obj) {
		this.level1Obj = level1Obj;
	}
	public Position getLevel2Obj() {
		return level2Obj;
	}
	public void setLevel2Obj(Position level2Obj) {
		this.level2Obj = level2Obj;
	}
	public Position getLevel3Obj() {
		return level3Obj;
	}
	public void setLevel3Obj(Position level3Obj) {
		this.level3Obj = level3Obj;
	}
	public Position getLevel4Obj() {
		return level4Obj;
	}
	public void setLevel4Obj(Position level4Obj) {
		this.level4Obj = level4Obj;
	}
	public Position getLevel5Obj() {
		return level5Obj;
	}
	public void setLevel5Obj(Position level5Obj) {
		this.level5Obj = level5Obj;
	}
	public Position getLevel6Obj() {
		return level6Obj;
	}
	public void setLevel6Obj(Position level6Obj) {
		this.level6Obj = level6Obj;
	}
	public Position getLevel7Obj() {
		return level7Obj;
	}
	public void setLevel7Obj(Position level7Obj) {
		this.level7Obj = level7Obj;
	}
	
}
