package com.omnia.pie.cm.web.rest.param;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeviceObjectResponse {
	
	@JsonProperty("Result")
	private String result;

	@JsonProperty("ResponseCode")
	private String responseCode;

	@JsonProperty("Error")
	private ResponseError error;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public ResponseError getError() {
		return error;
	}
	public void setError(ResponseError error) {
		this.error = error;
	}
}
