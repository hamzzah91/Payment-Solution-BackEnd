package com.omnia.pie.cm.data.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * GroupPermissionDirectory entity. 
 * @author M Louie
 */
@Entity
@Table(name = "user_group_permission_directory")

public class UserGroupPermissionDirectory extends com.omnia.pie.base.model.Entity implements java.io.Serializable {

	private static final long serialVersionUID = -349059389644153199L;
	// Fields
	private UserGroupPermissionType userGroupPermission;
	private UserGroup userGroup;

	// Constructors

	/** default constructor */
	public UserGroupPermissionDirectory() {
	}

	/** minimal constructor */
	public UserGroupPermissionDirectory(UserGroupPermissionType userGroupPermission, UserGroup userGroup) {
		this.userGroupPermission = userGroupPermission;
		this.userGroup = userGroup;
	}

	/** full constructor */
	public UserGroupPermissionDirectory(UserGroupPermissionType userGroupPermission, UserGroup userGroup, String created,
			String updated) {
		this.userGroupPermission = userGroupPermission;
		this.userGroup = userGroup;
		
		
	}

	// Property accessors

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_group_permission_type_id", nullable = false)

	public UserGroupPermissionType getUserGroupPermission() {
		return this.userGroupPermission;
	}

	public void setUserGroupPermission(UserGroupPermissionType userGroupPermission) {
		this.userGroupPermission = userGroupPermission;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_group_id", nullable = false)

	public UserGroup getUserGroup() {
		return this.userGroup;
	}

	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}

}