package com.omnia.pie.cm.web.rest.param;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SendSmsOtp implements java.io.Serializable {

	private static final long serialVersionUID = -6015610520601409109L;

	@JsonProperty("Otp")
	private String otp;

	@JsonProperty("Uuid")
	private String uuid;

	public String getOtp() {
		return otp;
	}

	public String getUuid() {
		return uuid;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@Override
	public String toString() {
		return "SendSmsOtp [otp=" + otp + ", uuid=" + uuid + "]";
	}

	public SendSmsOtp() {

	}

}
