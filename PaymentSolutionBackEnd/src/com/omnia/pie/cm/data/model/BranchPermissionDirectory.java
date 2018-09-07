package com.omnia.pie.cm.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * BranchPermissionDirectory entity. 
 * @author M Louie
 */
@Entity
@Table(name = "branch_permission_directory")

public class BranchPermissionDirectory extends com.omnia.pie.base.model.Entity implements java.io.Serializable {

	private static final long serialVersionUID = 7444347785749698244L;
	// Fields
	private BranchPermissionType branchPermissionType;
	private Integer userId;

	// Constructors

	/** default constructor */
	public BranchPermissionDirectory() {
	}

	/** full constructor */
	public BranchPermissionDirectory(BranchPermissionType branchPermissionType, Integer userId, String created,
			String updated) {
		this.branchPermissionType = branchPermissionType;
		this.userId = userId;
		
		
	}

	// Property accessors

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "branch_pemission_type_id")

	public BranchPermissionType getBranchPermissionType() {
		return this.branchPermissionType;
	}

	public void setBranchPermissionType(BranchPermissionType branchPermissionType) {
		this.branchPermissionType = branchPermissionType;
	}

	@Column(name = "user_id")

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}