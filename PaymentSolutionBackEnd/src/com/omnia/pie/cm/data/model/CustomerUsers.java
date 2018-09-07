package com.omnia.pie.cm.data.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * CustomerUsers entity. 
 * @author M Louie
 */
@Entity
@Table(name = "customer_users")
public class CustomerUsers extends com.omnia.pie.base.model.Entity implements java.io.Serializable {

	private static final long serialVersionUID = 1411532745240259093L;
	// Fields
	private Customer customer;
	private Users users;

	// Constructors

	/** default constructor */
	public CustomerUsers() {
	}

	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id")
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "users_id", unique = true, nullable = false)
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
	
}