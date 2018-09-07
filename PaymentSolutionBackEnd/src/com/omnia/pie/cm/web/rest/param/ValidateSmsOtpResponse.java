package com.omnia.pie.cm.web.rest.param;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ValidateSmsOtpResponse {
	
	@JsonProperty("ValidateSmsOtp")
	public ValidateSmsOtp validateSmsOtp;
	
	@JsonProperty("Error")
	public ErrorResponse errorRsp;
	
	@JsonProperty("ResponseCode")
	public String responseCode;
	
	public ValidateSmsOtpResponse(ValidateSmsOtp validateSmsOtp, ErrorResponse errorRsp, String responseCode) {
		super();
		this.validateSmsOtp = validateSmsOtp;
		this.errorRsp = errorRsp;
		this.responseCode = responseCode;
	}

	public ErrorResponse getErrorRsp() {
		return errorRsp;
	}

	public void setErrorRsp(ErrorResponse errorRsp) {
		this.errorRsp = errorRsp;
	}
	
	public ValidateSmsOtpResponse(ValidateSmsOtp validateSmsOtp, ErrorResponse errorRsp) {
		super();
		this.validateSmsOtp = validateSmsOtp;
		this.errorRsp = errorRsp;
	}

	public ValidateSmsOtpResponse()
	{
		
	}

	public ValidateSmsOtp getValidateSmsOtp() {
		return validateSmsOtp;
	}

	public void setValidateSmsOtp(ValidateSmsOtp validateSmsOtp) {
		this.validateSmsOtp = validateSmsOtp;
	}

	@Override
	public String toString() {
		return "ValidateSmsOtpResponse [validateSmsOtp=" + validateSmsOtp + ", errorRsp=" + errorRsp + ", responseCode="
				+ responseCode + "]";
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
}
