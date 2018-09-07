package com.omnia.pie.cm.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Usalt entity. 
 * @author M Louie
 */
@Entity
@Table(name = "usalt")

public class Usalt extends com.omnia.pie.base.model.Entity implements java.io.Serializable {

	private static final long serialVersionUID = 9155630885573614592L;
	// Fields
	private Users users;
	private String salt;

	// Constructors

	/** default constructor */
	public Usalt() {
	}

	/** full constructor */
	public Usalt(Users users, String salt) {
		this.users = users;
		this.salt = salt;
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

}