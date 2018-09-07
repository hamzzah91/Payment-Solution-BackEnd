package com.omnia.pie.cm.web.rest.param;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ValidateSmsOtpRequest implements java.io.Serializable {
	private static final long serialVersionUID = -6015610520601409109L;
	@JsonProperty("TransactionData")
	private TransactionDataRequest transactionData;

	@JsonProperty("Terminal")
	private TerminalRequest terminal;
	
	@JsonProperty("Otp")
	private String otp;
	
	@JsonProperty("Uuid")
	private String uuid;

	@JsonProperty("PhoneNo")
	private String phoneNo;
	
	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public TransactionDataRequest getTransactionData() {
		return transactionData;
	}

	public TerminalRequest getTerminal() {
		return terminal;
	}

	public void setTransactionData(TransactionDataRequest transactionData) {
		this.transactionData = transactionData;
	}

	public void setTerminal(TerminalRequest terminal) {
		this.terminal = terminal;
	}

	public ValidateSmsOtpRequest() {

	}

	public String getOtp() {
		return otp;
	}

	public String getUuid() {
		return uuid;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@Override
	public String toString() {
		return "ValidateSmsOtpRequest [transactionData=" + transactionData + ", terminal=" + terminal + ", otp=" + otp
				+ ", uuid=" + uuid + "]";
	}
}
