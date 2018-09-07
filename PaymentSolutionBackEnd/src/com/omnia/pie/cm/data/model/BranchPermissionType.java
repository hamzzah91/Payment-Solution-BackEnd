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
 * BranchPermissionType entity. 
 * @author M Louie
 */
@Entity
@Table(name = "branch_permission_type")

public class BranchPermissionType extends com.omnia.pie.base.model.Entity implements java.io.Serializable {

	private static final long serialVersionUID = 1733861163910803421L;
	// Fields
	private String permission;
	private String description;
	private Set<BranchPermissionDirectory> branchPermissionDirectories = new HashSet<BranchPermissionDirectory>(0);

	// Constructors

	/** default constructor */
	public BranchPermissionType() {
	}

	/** minimal constructor */
	public BranchPermissionType(String permission) {
		this.permission = permission;
	}

	/** full constructor */
	public BranchPermissionType(String permission, String description,
			Set<BranchPermissionDirectory> branchPermissionDirectories) {
		this.permission = permission;
		this.description = description;
		
		
		this.branchPermissionDirectories = branchPermissionDirectories;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "branchPermissionType")

	public Set<BranchPermissionDirectory> getBranchPermissionDirectories() {
		return this.branchPermissionDirectories;
	}

	public void setBranchPermissionDirectories(Set<BranchPermissionDirectory> branchPermissionDirectories) {
		this.branchPermissionDirectories = branchPermissionDirectories;
	}

}