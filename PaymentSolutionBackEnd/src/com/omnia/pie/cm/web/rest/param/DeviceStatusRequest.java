package com.omnia.pie.cm.web.rest.param;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeviceStatusRequest {

	@JsonProperty("terminal")
	private String terminal;

	
	public DeviceStatusRequest(String terminal) {
		super();
		this.terminal = terminal;
	}

	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}
}
