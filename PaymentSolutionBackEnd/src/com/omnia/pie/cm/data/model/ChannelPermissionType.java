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
 * ChannelPermissionType entity. 
 * @author M Louie
 */
@Entity
@Table(name = "channel_permission_type")

public class ChannelPermissionType extends com.omnia.pie.base.model.Entity implements java.io.Serializable {

	private static final long serialVersionUID = -5462942183308601489L;
	// Fields
	private String permission;
	private String description;
	private Set<ChannelPermissionDirectory> channelPermissionDirectories = new HashSet<ChannelPermissionDirectory>(0);

	// Constructors

	/** default constructor */
	public ChannelPermissionType() {
	}

	/** minimal constructor */
	public ChannelPermissionType(String permission) {
		this.permission = permission;
	}

	/** full constructor */
	public ChannelPermissionType(String permission, String description,
			Set<ChannelPermissionDirectory> channelPermissionDirectories) {
		this.permission = permission;
		this.description = description;
		
		
		this.channelPermissionDirectories = channelPermissionDirectories;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "channelPermissionType")

	public Set<ChannelPermissionDirectory> getChannelPermissionDirectories() {
		return this.channelPermissionDirectories;
	}

	public void setChannelPermissionDirectories(Set<ChannelPermissionDirectory> channelPermissionDirectories) {
		this.channelPermissionDirectories = channelPermissionDirectories;
	}

}