package com.omnia.pie.cm.ui.model.vtm;

import java.io.Serializable;

public class UserGroupUI implements Serializable{
	private static final long serialVersionUID = 3177814566230498905L;
	
	private long id;
	private String name;
	private String grpCode;
	
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
	public String getGrpCode() {
		return grpCode;
	}
	public void setGrpCode(String grpCode) {
		this.grpCode = grpCode;
	}
	
	public String toString(){
		return id + "," + grpCode + "," + name;
	}
}
