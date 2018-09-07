package com.omnia.pie.cm.web.rest.param;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponse implements java.io.Serializable {

	private static final long serialVersionUID = -6015610520601409109L;
	
	private String errorMessageText;
	private String errorMessageType;
	private String errorCode;
	private String errorState;
	
	@JsonProperty("ErrorMessageText")
	public String getErrorMessageText() {
		return errorMessageText;
	}
	
	@JsonProperty("ErrorMessageType")
	public String getErrorMessageType() {
		return errorMessageType;
	}
	
	@JsonProperty("ErrorCode")
	public String getErrorCode() {
		return errorCode;
	}
	
	@JsonProperty("ErrorState")
	public String getErrorState() {
		return errorState;
	}
	
	
	public void setErrorMessageText(String errorMessageText) {
		this.errorMessageText = errorMessageText;
	}
	
	public void setErrorMessageType(String errorMessageType) {
		this.errorMessageType = errorMessageType;
	}
	
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	public void setErrorState(String errorState) {
		this.errorState = errorState;
	}
	
	@Override
	public String toString() {
		return "Error [errorMessageText=" + errorMessageText + ", errorMessageType=" + errorMessageType + ", errorCode="
				+ errorCode + ", errorState=" + errorState + "]";
	}
	public ErrorResponse(String errorMessageText, String errorMessageType, String errorCode, String errorState) {
		super();
		this.errorMessageText = errorMessageText;
		this.errorMessageType = errorMessageType;
		this.errorCode = errorCode;
		this.errorState = errorState;
	}
	
	public ErrorResponse()
	{
		
	}
	
}
