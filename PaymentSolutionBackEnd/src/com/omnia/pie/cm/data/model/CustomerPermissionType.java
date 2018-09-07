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
 * CustomerPermissionType entity. 
 * @author M Louie
 */
@Entity
@Table(name = "customer_permission_type")

public class CustomerPermissionType extends com.omnia.pie.base.model.Entity implements java.io.Serializable {

	private static final long serialVersionUID = 6564438095170348464L;
	// Fields
	private String channel;
	private String permission;
	private String description;
	private Set<CustomerPermissionDirectory> customerPermissionDirectories = new HashSet<CustomerPermissionDirectory>(
			0);

	// Constructors

	/** default constructor */
	public CustomerPermissionType() {
	}

	/** minimal constructor */
	public CustomerPermissionType(String permission) {
		this.permission = permission;
	}

	/** full constructor */
	public CustomerPermissionType(String permission, String description,
			Set<CustomerPermissionDirectory> customerPermissionDirectories) {
		this.permission = permission;
		this.description = description;
		
		
		this.customerPermissionDirectories = customerPermissionDirectories;
	}

	// Property accessors

	@Column(name = "channel", length = 10)
	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}
	
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customerPermissionType")

	public Set<CustomerPermissionDirectory> getCustomerPermissionDirectories() {
		return this.customerPermissionDirectories;
	}

	public void setCustomerPermissionDirectories(Set<CustomerPermissionDirectory> customerPermissionDirectories) {
		this.customerPermissionDirectories = customerPermissionDirectories;
	}

}