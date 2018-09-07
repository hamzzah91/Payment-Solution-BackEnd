package com.omnia.pie.cm.data.model;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Users entity. 
 * @author hamza
 */
@Entity
@Table(name = "users")

public class Users extends com.omnia.pie.base.model.Entity implements java.io.Serializable {

	private static final long serialVersionUID = -4661252987829454034L;
	// Fields
	private UserGroup userGroup;
	private String username;
	private String password;
	private ZonedDateTime lastLogin;
	private ZonedDateTime passwordDate;
	private ZonedDateTime passwordBlockedUntil;
	private Boolean passwordBlocked;
	private String email;
	private Set<UserPermissionDirectory> userPermissionDirectories = new HashSet<UserPermissionDirectory>(0);
	private Set<UserHistory> userHistories = new HashSet<UserHistory>(0);
	private Set<Usalt> usalts = new HashSet<Usalt>(0);

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(String username) {
		this.username = username;
	}

	/** full constructor */
	public Users(UserGroup userGroup, String username, String password, ZonedDateTime lastLogin, ZonedDateTime passwordDate,
			ZonedDateTime passwordBlockedUntil, Boolean passwordBlocked, String email,
			Set<UserPermissionDirectory> userPermissionDirectories, Set<UserHistory> userHistories, Set<Usalt> usalts) {
		this.userGroup = userGroup;
		this.username = username;
		this.password = password;
		this.lastLogin = lastLogin;
		this.passwordDate = passwordDate;
		this.passwordBlockedUntil = passwordBlockedUntil;
		this.passwordBlocked = passwordBlocked;
		this.email = email;
		
		
		this.userPermissionDirectories = userPermissionDirectories;
		this.userHistories = userHistories;
		this.usalts = usalts;
	}

	// Property accessors

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_group_id")

	public UserGroup getUserGroup() {
		return this.userGroup;
	}

	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}

	@Column(name = "username", nullable = false, length = 64)

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", length = 64)

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "last_login")

	public ZonedDateTime getLastLogin() {
		return this.lastLogin;
	}

	public void setLastLogin(ZonedDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}

	@Column(name = "password_date")

	public ZonedDateTime getPasswordDate() {
		return this.passwordDate;
	}

	public void setPasswordDate(ZonedDateTime passwordDate) {
		this.passwordDate = passwordDate;
	}

	@Column(name = "password_blocked_until")

	public ZonedDateTime getPasswordBlockedUntil() {
		return this.passwordBlockedUntil;
	}

	public void setPasswordBlockedUntil(ZonedDateTime passwordBlockedUntil) {
		this.passwordBlockedUntil = passwordBlockedUntil;
	}

	@Column(name = "password_blocked")

	public Boolean getPasswordBlocked() {
		return this.passwordBlocked;
	}

	public void setPasswordBlocked(Boolean passwordBlocked) {
		this.passwordBlocked = passwordBlocked;
	}

	@Column(name = "email", length = 50)

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")

	public Set<UserPermissionDirectory> getUserPermissionDirectories() {
		return this.userPermissionDirectories;
	}

	public void setUserPermissionDirectories(Set<UserPermissionDirectory> userPermissionDirectories) {
		this.userPermissionDirectories = userPermissionDirectories;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")

	public Set<UserHistory> getUserHistories() {
		return this.userHistories;
	}

	public void setUserHistories(Set<UserHistory> userHistories) {
		this.userHistories = userHistories;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")

	public Set<Usalt> getUsalts() {
		return this.usalts;
	}

	public void setUsalts(Set<Usalt> usalts) {
		this.usalts = usalts;
	}

}