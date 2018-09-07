package com.omnia.pie.cm.web.rest.param;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ValidateSmsOtpRequestParam implements java.io.Serializable {
	private static final long serialVersionUID = -6015610520601409109L;
	
	@JsonProperty("ValidateSmsOtpRequest")
	private ValidateSmsOtpRequest validateSmsOtpRequest;

	public ValidateSmsOtpRequest getValidateSmsOtpRequest() {
		return validateSmsOtpRequest;
	}

	public void setValidateSmsOtpRequest(ValidateSmsOtpRequest validateSmsOtpRequest) {
		this.validateSmsOtpRequest = validateSmsOtpRequest;
	}

	public ValidateSmsOtpRequestParam(ValidateSmsOtpRequest validateSmsOtpRequest) {
		super();
		this.validateSmsOtpRequest = validateSmsOtpRequest;
	}

	@Override
	public String toString() {
		return "ValidateSmsOtpRequestParam [validateSmsOtpRequest=" + validateSmsOtpRequest + "]";
	} 
	
	public ValidateSmsOtpRequestParam()
	{
		
	}
	
}
