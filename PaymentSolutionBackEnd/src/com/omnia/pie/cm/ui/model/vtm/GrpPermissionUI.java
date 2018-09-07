package com.omnia.pie.cm.ui.model.vtm;

import java.io.Serializable;

public class GrpPermissionUI implements Serializable {
	private static final long serialVersionUID = 3947400473016068161L;
	
	private boolean allowed;
	private long id;
	private String permission;
	private String description;
	
	public GrpPermissionUI(long id, String permission, String description){
		this.id = id;
		this.permission = permission;
		this.description = description;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isAllowed() {
		return allowed;
	}

	public void setAllowed(boolean allowed) {
		this.allowed = allowed;
	}
	
}
