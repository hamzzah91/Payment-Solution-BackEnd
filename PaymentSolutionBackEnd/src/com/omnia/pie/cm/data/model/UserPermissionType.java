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
 * UserPermissionType entity. 
 * @author M Louie
 */
@Entity
@Table(name = "user_permission_type")

public class UserPermissionType extends com.omnia.pie.base.model.Entity implements java.io.Serializable {

	private static final long serialVersionUID = 3575698703678265334L;
	// Fields
	private String permission;
	private String description;
	private Set<UserPermissionDirectory> userPermissionDirectories = new HashSet<UserPermissionDirectory>(0);

	// Constructors

	/** default constructor */
	public UserPermissionType() {
	}

	/** minimal constructor */
	public UserPermissionType(String permission) {
		this.permission = permission;
	}

	/** full constructor */
	public UserPermissionType(String permission, String description,
			Set<UserPermissionDirectory> userPermissionDirectories) {
		this.permission = permission;
		this.description = description;
		
		
		this.userPermissionDirectories = userPermissionDirectories;
	}

	// Property accessors

	@Column(name = "permission", nullable = false, length = 50)

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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userPermissionType")

	public Set<UserPermissionDirectory> getUserPermissionDirectories() {
		return this.userPermissionDirectories;
	}

	public void setUserPermissionDirectories(Set<UserPermissionDirectory> userPermissionDirectories) {
		this.userPermissionDirectories = userPermissionDirectories;
	}

}