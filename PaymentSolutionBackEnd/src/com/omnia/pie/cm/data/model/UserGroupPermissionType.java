package com.omnia.pie.cm.data.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * UserGroupPermissionType entity. 
 * @author M Louie
 */
@Entity
@Table(name = "user_group_permission_type")

public class UserGroupPermissionType extends com.omnia.pie.base.model.Entity implements java.io.Serializable {

	private static final long serialVersionUID = -7384107126252348762L;
	// Fields
	private String permission;
	private String description;
	private String channel;
	private Set<UserGroupPermissionDirectory> groupPermissionDirectories = new HashSet<UserGroupPermissionDirectory>(0);

	// Constructors

	/** default constructor */
	public UserGroupPermissionType() {
	}

	/** full constructor */
	public UserGroupPermissionType(String permission, String description,
			Set<UserGroupPermissionDirectory> groupPermissionDirectories) {
		this.permission = permission;
		this.description = description;
		this.groupPermissionDirectories = groupPermissionDirectories;
	}

	// Property accessors

	@Column(name = "permission", length = 50)
	public String getPermission() {
		return this.permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}
	
	@Column(name = "description", length = 150)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	

	@Column(name = "channel", length = 10)
	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userGroupPermission")
	public Set<UserGroupPermissionDirectory> getGroupPermissionDirectories() {
		return this.groupPermissionDirectories;
	}

	public void setGroupPermissionDirectories(Set<UserGroupPermissionDirectory> groupPermissionDirectories) {
		this.groupPermissionDirectories = groupPermissionDirectories;
	}


}