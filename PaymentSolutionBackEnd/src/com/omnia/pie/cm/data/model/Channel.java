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
 * Channel entity. 
 * @author M Louie
 */
@Entity
@Table(name = "channel")

public class Channel extends com.omnia.pie.base.model.Entity implements java.io.Serializable {

	private static final long serialVersionUID = -6782187857496934676L;
	// Fields
	private String channelName;
	private String channelLongName;
	private Set<TerminalInfo> terminalInfos = new HashSet<TerminalInfo>(0);
		private Set<Branch> branchs = new HashSet<Branch>(0);
	private Set<Customer> customers = new HashSet<Customer>(0);

	// Constructors

	/** default constructor */
	public Channel() {
	}

	
	// Property accessors

	@Column(name = "channel_name", length = 10)

	public String getChannelName() {
		return this.channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	@Column(name = "channel_long_name", length = 100)

	public String getChannelLongName() {
		return this.channelLongName;
	}

	public void setChannelLongName(String channelLongName) {
		this.channelLongName = channelLongName;
	}

	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "channel")

	public Set<TerminalInfo> getTerminalInfos() {
		return this.terminalInfos;
	}

	public void setTerminalInfos(Set<TerminalInfo> terminalInfos) {
		this.terminalInfos = terminalInfos;
	}



	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "channel")

	public Set<Branch> getBranchs() {
		return this.branchs;
	}

	public void setBranchs(Set<Branch> branchs) {
		this.branchs = branchs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "channel")

	public Set<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

}