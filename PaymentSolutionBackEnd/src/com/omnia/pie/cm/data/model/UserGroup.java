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
 * UserGroup entity. 
 * @author M Louie
 */
@Entity
@Table(name = "user_group")

public class UserGroup extends com.omnia.pie.base.model.Entity implements java.io.Serializable {

	private static final long serialVersionUID = 2441562745247259496L;
	// Fields
	private String name;
	private String groupCategoryCode;
	private Set<Users> userses = new HashSet<Users>(0);
	private Set<UserGroupPermissionDirectory> groupPermissionDirectories = new HashSet<UserGroupPermissionDirectory>(0);

	// Constructors

	/** default constructor */
	public UserGroup() {
	}

	public UserGroup(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	/** full constructor */
	public UserGroup(String name, Set<Users> userses,
			Set<UserGroupPermissionDirectory> groupPermissionDirectories) {
		this.name = name;
		
		
		this.userses = userses;
		this.groupPermissionDirectories = groupPermissionDirectories;
	}

	// Property accessors

	@Column(name = "name", length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Column(name = "group_category_code", length = 20)
	public String getGroupCategoryCode() {
		return groupCategoryCode;
	}

	public void setGroupCategoryCode(String groupCategoryCode) {
		this.groupCategoryCode = groupCategoryCode;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userGroup")

	public Set<Users> getUserses() {
		return this.userses;
	}

	public void setUserses(Set<Users> userses) {
		this.userses = userses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userGroup")

	public Set<UserGroupPermissionDirectory> getGroupPermissionDirectories() {
		return this.groupPermissionDirectories;
	}

	public void setGroupPermissionDirectories(Set<UserGroupPermissionDirectory> groupPermissionDirectories) {
		this.groupPermissionDirectories = groupPermissionDirectories;
	}


}