package com.omnia.pie.cm.web.rest.param;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TerminalPermissions {

	@JsonProperty("Platform")
	protected String platform;

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}
}
