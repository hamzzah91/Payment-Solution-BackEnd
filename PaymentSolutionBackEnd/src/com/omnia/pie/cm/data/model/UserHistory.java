package com.omnia.pie.cm.data.model;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * UserHistory entity. 
 * @author M Louie
 */
@Entity
@Table(name = "user_history")

public class UserHistory extends com.omnia.pie.base.model.Entity implements java.io.Serializable {

	private static final long serialVersionUID = -8399767393084833623L;
	// Fields
	private Users users;
	private String salt;
	private String password;
	private ZonedDateTime passwordDate;

	// Constructors

	/** default constructor */
	public UserHistory() {
	}

	/** full constructor */
	public UserHistory(Users users, String salt, String password, ZonedDateTime passwordDate) {
		this.users = users;
		this.salt = salt;
		this.password = password;
		this.passwordDate = passwordDate;
	}

	// Property accessors

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Column(name = "salt", length = 32)

	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Column(name = "password", length = 64)

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "password_date")

	public ZonedDateTime getPasswordDate() {
		return this.passwordDate;
	}

	public void setPasswordDate(ZonedDateTime passwordDate) {
		this.passwordDate = passwordDate;
	}

}