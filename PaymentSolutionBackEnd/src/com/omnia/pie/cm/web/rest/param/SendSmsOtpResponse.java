package com.omnia.pie.cm.web.rest.param;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SendSmsOtpResponse implements java.io.Serializable {

	private static final long serialVersionUID = -6015610520601409109L;

	@JsonProperty("SendSmsOtp")
	public SendSmsOtp sendsmsotp;

	@JsonProperty("ResponseCode")
	private String responseCode;

	@JsonProperty("Error")
	public ErrorResponse errorRsp;

	public SendSmsOtp getSendsmsotp() {
		return sendsmsotp;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public ErrorResponse getErrorRsp() {
		return errorRsp;
	}

	public void setSendsmsotp(SendSmsOtp sendsmsotp) {
		this.sendsmsotp = sendsmsotp;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public void setErrorRsp(ErrorResponse errorRsp) {
		this.errorRsp = errorRsp;
	}

	@Override
	public String toString() {
		return "SendSmsOtpResponse [sendsmsotp=" + sendsmsotp + ", responseCode=" + responseCode + ", errorRsp="
				+ errorRsp + "]";
	}

	public SendSmsOtpResponse() {

	}

}
