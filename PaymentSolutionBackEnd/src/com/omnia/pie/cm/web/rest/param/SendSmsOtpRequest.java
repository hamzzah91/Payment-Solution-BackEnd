package com.omnia.pie.cm.web.rest.param;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SendSmsOtpRequest implements java.io.Serializable {
	private static final long serialVersionUID = -6015610520601409109L;
	@JsonProperty("TransactionData")
	private TransactionDataRequest transactionData;

	@JsonProperty("Terminal")
	private TerminalRequest terminal;

	@JsonProperty("CustomerIdentifier")
	private String customerIdentifier;
	
	@JsonProperty("SMSExpiryTime")
	private String smsExpiryTime;
	
	@JsonProperty("PhoneNo")
	private String phoneNo;
	
	@JsonProperty("FirstName")
	private String firstName;
	
	@JsonProperty("LastName")
	private String lastName;

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public TransactionDataRequest getTransactionData() {
		return transactionData;
	}

	public TerminalRequest getTerminal() {
		return terminal;
	}

	public String getCustomerIdentifier() {
		return customerIdentifier;
	}

	public void setTransactionData(TransactionDataRequest transactionData) {
		this.transactionData = transactionData;
	}

	public void setTerminal(TerminalRequest terminal) {
		this.terminal = terminal;
	}

	public void setCustomerIdentifier(String customerIdentifier) {
		this.customerIdentifier = customerIdentifier;
	}

	@Override
	public String toString() {
		return "SendSmsOtpRequest [" + (transactionData != null ? "transactionData=" + transactionData + ", " : "")
				+ (terminal != null ? "terminal=" + terminal + ", " : "")
				+ (customerIdentifier != null ? "customerIdentifier=" + customerIdentifier + ", " : "")
				+ (smsExpiryTime != null ? "smsExpiryTime=" + smsExpiryTime : "") + "]";
	}

	public SendSmsOtpRequest() {

	}

	public String getSmsExpiryTime() {
		return smsExpiryTime;
	}

	public void setSmsExpiryTime(String smsExpiryTime) {
		this.smsExpiryTime = smsExpiryTime;
	}

}
