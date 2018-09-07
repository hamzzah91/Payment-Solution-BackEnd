package com.omnia.pie.cm.web.rest.param;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SendSmsOtpRequestParam implements java.io.Serializable {
	
	private static final long serialVersionUID = -6015610520601409109L;
	
	@JsonProperty("SendSmsOtpRequest")
	private SendSmsOtpRequest sendSmsOtpRequest;

	public SendSmsOtpRequest getSendSmsOtpRequest() {
		return sendSmsOtpRequest;
	}

	public void setSendSmsOtpRequest(SendSmsOtpRequest sendSmsOtpRequest) {
		this.sendSmsOtpRequest = sendSmsOtpRequest;
	}

	public SendSmsOtpRequestParam(SendSmsOtpRequest sendSmsOtpRequest) {
		super();
		this.sendSmsOtpRequest = sendSmsOtpRequest;
	}

	@Override
	public String toString() {
		return "SendSmsOtpRequestParam [sendSmsOtpRequest=" + sendSmsOtpRequest + "]";
	}
	
	public SendSmsOtpRequestParam()
	{
		
	}
	

}
