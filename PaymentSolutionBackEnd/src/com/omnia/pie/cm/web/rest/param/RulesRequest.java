package com.omnia.pie.cm.web.rest.param;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RulesRequest {

	@JsonProperty("ActionCode")
	private String actionCode;
	
	@JsonProperty("DeviceState")
	private String deviceState;

	public RulesRequest(){}
	
	public RulesRequest(String actionCode){
		this.actionCode = actionCode;
	}
	
	public RulesRequest(String actionCode, String deviceState){
		this.actionCode = actionCode;
		this.deviceState = deviceState;
	}

	public String getActionCode() {
		return actionCode;
	}

	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}

	public String getDeviceState() {
		return deviceState;
	}

	public void setDeviceState(String deviceState) {
		this.deviceState = deviceState;
	}
	
	
}
