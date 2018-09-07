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
 * TerminalInfo entity. 
 * @author M Louie
 */
@Entity
@Table(name = "terminal_info")
public class TerminalInfo extends com.omnia.pie.base.model.Entity implements java.io.Serializable {

	private static final long serialVersionUID = -2507025656509647395L;
	// Fields
	private Customer customer;
	private Channel channel;
	private Branch branch;
	private String terminalId;
	private String currencyCode;
	private String merchantId;
	private String acquirerInstId;
	private String modelNo;
	private String machineSerialNo;

	

		/** default constructor */
	public TerminalInfo() {
	}

	/** minimal constructor */
	public TerminalInfo(String terminalId) {
		this.terminalId = terminalId;
	}

	// Property accessors

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id")
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "channel_id")
	public Channel getChannel() {
		return this.channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "branch_id")
	public Branch getBranch() {
		return this.branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	@Column(name = "terminal_id", nullable = false, length = 20)
	public String getTerminalId() {
		return this.terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	@Column(name = "currency_code", length = 3)
	public String getCurrencyCode() {
		return this.currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	@Column(name = "merchant_id", length = 16)
	public String getMerchantId() {
		return this.merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	@Column(name = "acquirer_inst_id", length = 16)
	public String getAcquirerInstId() {
		return this.acquirerInstId;
	}

	public void setAcquirerInstId(String acquirerInstId) {
		this.acquirerInstId = acquirerInstId;
	}

	@Column(name = "model_no", length = 50)
	public String getModelNo() {
		return modelNo;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}
	
	@Column(name = "machine_serial_no", length = 20)
	public String getMachineSerialNo() {
		return this.machineSerialNo;
	}

	public void setMachineSerialNo(String machineSerialNo) {
		this.machineSerialNo = machineSerialNo;
	}

}