package com.omnia.pie.cm.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * CustomerPermissionDirectory entity. 
 * @author M Louie
 */
@Entity
@Table(name = "customer_permission_directory")

public class CustomerPermissionDirectory extends com.omnia.pie.base.model.Entity implements java.io.Serializable {

	private static final long serialVersionUID = 6183874749799875576L;
	// Fields
	private CustomerPermissionType customerPermissionType;
	private Integer userId;

	// Constructors

	/** default constructor */
	public CustomerPermissionDirectory() {
	}

	/** full constructor */
	public CustomerPermissionDirectory(CustomerPermissionType customerPermissionType, Integer userId, String created,
			String updated) {
		this.customerPermissionType = customerPermissionType;
		this.userId = userId;
		
		
	}

	// Property accessors

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_pemission_type_id")

	public CustomerPermissionType getCustomerPermissionType() {
		return this.customerPermissionType;
	}

	public void setCustomerPermissionType(CustomerPermissionType customerPermissionType) {
		this.customerPermissionType = customerPermissionType;
	}

	@Column(name = "user_id")

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}