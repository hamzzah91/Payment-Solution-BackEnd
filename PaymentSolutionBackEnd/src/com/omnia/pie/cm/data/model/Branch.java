package com.omnia.pie.cm.data.model;

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
 * Branch entity. 
 * @author M Louie
 */
@Entity
@Table(name = "branch")

public class Branch extends com.omnia.pie.base.model.Entity implements java.io.Serializable {

	private static final long serialVersionUID = 8581519132088783394L;
	// Fields
	private Customer customer;
	private Channel channel;
	private String branchName;
	private String branchCode;
	private String building;
	private String street;
	private String city;
	private String state;
	private String country;
	private Set<TerminalInfo> terminalInfos = new HashSet<TerminalInfo>(0);

	// Constructors

	/** default constructor */
	public Branch() {
	}

	/** full constructor */
	public Branch(Customer customer, Channel channel, String branchName, String branchCode, String building,
			String street, String city, String state, String country, 
			Set<TerminalInfo> terminalInfos) {
		this.customer = customer;
		this.channel = channel;
		this.branchName = branchName;
		this.branchCode = branchCode;
		this.building = building;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.terminalInfos = terminalInfos;
	}

	// Property accessors

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "channel_id")

	public Channel getChannel() {
		return this.channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	@Column(name = "branch_name", length = 150)

	public String getBranchName() {
		return this.branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	@Column(name = "branch_code", length = 20)

	public String getBranchCode() {
		return this.branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	@Column(name = "building", length = 150)

	public String getBuilding() {
		return this.building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	@Column(name = "street", length = 150)

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Column(name = "city", length = 50)

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "state", length = 50)

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "country", length = 50)

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "branch")

	public Set<TerminalInfo> getTerminalInfos() {
		return this.terminalInfos;
	}

	public void setTerminalInfos(Set<TerminalInfo> terminalInfos) {
		this.terminalInfos = terminalInfos;
	}

}