package com.omnia.pie.cm.web.rest.param;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseError {

	@JsonProperty("ErrorMessageText")
	private String errorMessageText;
	
	@JsonProperty("ErrorMessageType")
	private String errorMessageType;
	
	@JsonProperty("ErrorCode")
	private String errorCode;
	
	@JsonProperty("ErrorState")
	private String errorState;

	public String getErrorMessageText() {
		return errorMessageText;
	}

	public void setErrorMessageText(String errorMessageText) {
		this.errorMessageText = errorMessageText;
	}

	public String getErrorMessageType() {
		return errorMessageType;
	}

	public void setErrorMessageType(String errorMessageType) {
		this.errorMessageType = errorMessageType;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorState() {
		return errorState;
	}

	public void setErrorState(String errorState) {
		this.errorState = errorState;
	}
}
