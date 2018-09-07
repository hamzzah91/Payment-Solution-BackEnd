package com.omnia.pie.cm.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
/**
 * Users entity. 
 * @author hamza
 */
@Entity
@Table(name = "user_info")
public class UserInfo extends com.omnia.pie.base.model.Entity implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4245322308420239974L;
	private String phone;
	private String lastName;
	private String firstName;
	
	@Column(name="phone", nullable=false)
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Column(name="last_name")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name="first_name")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
}
