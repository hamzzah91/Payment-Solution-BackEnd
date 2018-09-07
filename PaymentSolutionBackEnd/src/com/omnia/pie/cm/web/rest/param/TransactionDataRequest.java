package com.omnia.pie.cm.web.rest.param;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionDataRequest implements java.io.Serializable{

	private static final long serialVersionUID = -6015610520601409109L;
	
	@JsonProperty("TransactionNumber")
	private String transactionNumber;
	
	@JsonProperty("TransactionType")
	private String transactionType;
	
	@JsonProperty("SessionId")
	private String sessionId;
	

	public String getTransactionNumber() {
		return transactionNumber;
	}


	public String getTransactionType() {
		return transactionType;
	}


	public String getSessionId() {
		return sessionId;
	}


	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}


	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public TransactionDataRequest(String transactionNumber, String transactionType, String sessionId) {
		super();
		this.transactionNumber = transactionNumber;
		this.transactionType = transactionType;
		this.sessionId = sessionId;
	}
		
	@Override
	public String toString() {
		return "TransactionDataParam [transactionNumber=" + transactionNumber + ", transactionType="
				+ transactionType + ", sessionId=" + sessionId + "]";
	}

	public TransactionDataRequest()
	{
		
	}

}
