package com.omnia.pie.cm.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ChannelPermissionDirectory entity. 
 * @author M Louie
 */
@Entity
@Table(name = "channel_permission_directory")

public class ChannelPermissionDirectory extends com.omnia.pie.base.model.Entity implements java.io.Serializable {

	private static final long serialVersionUID = 1469920590209283169L;
	// Fields
	private ChannelPermissionType channelPermissionType;
	private Integer userId;

	// Constructors

	/** default constructor */
	public ChannelPermissionDirectory() {
	}

	/** full constructor */
	public ChannelPermissionDirectory(ChannelPermissionType channelPermissionType, Integer userId, String created,
			String updated) {
		this.channelPermissionType = channelPermissionType;
		this.userId = userId;
		
		
	}

	// Property accessors

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "channel_pemission_type_id")

	public ChannelPermissionType getChannelPermissionType() {
		return this.channelPermissionType;
	}

	public void setChannelPermissionType(ChannelPermissionType channelPermissionType) {
		this.channelPermissionType = channelPermissionType;
	}

	@Column(name = "user_id")

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}