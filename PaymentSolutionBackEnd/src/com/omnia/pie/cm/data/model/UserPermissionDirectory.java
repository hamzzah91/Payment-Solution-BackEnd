package com.omnia.pie.cm.data.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * UserPermissionDirectory entity. 
 * @author M Louie
 */
@Entity
@Table(name = "user_permission_directory")

public class UserPermissionDirectory extends com.omnia.pie.base.model.Entity implements java.io.Serializable {

	private static final long serialVersionUID = -3674488783178713301L;
	// Fields
	private UserPermissionType userPermissionType;
	private Users users;

	// Constructors

	/** default constructor */
	public UserPermissionDirectory() {
	}

	/** full constructor */
	public UserPermissionDirectory(UserPermissionType userPermissionType, Users users) {
		this.userPermissionType = userPermissionType;
		this.users = users;
		
		
	}

	// Property accessors

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_pemission_type_id")

	public UserPermissionType getUserPermissionType() {
		return this.userPermissionType;
	}

	public void setUserPermissionType(UserPermissionType userPermissionType) {
		this.userPermissionType = userPermissionType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

}