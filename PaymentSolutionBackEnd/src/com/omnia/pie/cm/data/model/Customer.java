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
 * Customer entity. 
 * @author M Louie
 */
@Entity
@Table(name = "customer")

public class Customer extends com.omnia.pie.base.model.Entity implements java.io.Serializable {

	private static final long serialVersionUID = 7517055934204752542L;
	// Fields
	private Channel channel;
	private String name;
	private String shortName;
	private Set<TerminalInfo> terminalInfos = new HashSet<TerminalInfo>(0);
	private Set<Branch> branchs = new HashSet<Branch>(0);

	// Constructors

	/** default constructor */
	public Customer() {
	}

		// Property accessors

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "channel_id")

	public Channel getChannel() {
		return this.channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	@Column(name = "name", length = 150)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "short_name", length = 100)

	public String getShortName() {
		return this.shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")
	public Set<TerminalInfo> getTerminalInfos() {
		return this.terminalInfos;
	}

	public void setTerminalInfos(Set<TerminalInfo> terminalInfos) {
		this.terminalInfos = terminalInfos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")
	public Set<Branch> getBranchs() {
		return this.branchs;
	}

	public void setBranchs(Set<Branch> branchs) {
		this.branchs = branchs;
	}

}