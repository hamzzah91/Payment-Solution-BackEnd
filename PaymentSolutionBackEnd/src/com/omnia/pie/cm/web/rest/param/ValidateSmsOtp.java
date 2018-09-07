package com.omnia.pie.cm.web.rest.param;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ValidateSmsOtp implements Serializable {

	private static final long serialVersionUID = -1881684681325332996L;
	
	@JsonProperty("OtpMatched")
	private String otpMatched;
	
	@JsonProperty("OtpMismatchCount")
	private String otpMismatchCount;
	
	/*@JsonProperty("EmiratesId")
	private String eid;*/

	@Override
	public String toString() {
		return "ValidateSmsOtp [otpMatched=" + otpMatched + ", otpMismatchCount=" + otpMismatchCount + "]";
	}

	public String getOtpMatched() {
		return otpMatched;
	}

	public String getOtpMismatchCount() {
		return otpMismatchCount;
	}

	public void setOtpMatched(String otpMatched) {
		this.otpMatched = otpMatched;
	}

	public void setOtpMismatchCount(String otpMismatchCount) {
		this.otpMismatchCount = otpMismatchCount;
	}

	public ValidateSmsOtp(String otpMatched, String otpMismatchCount) {
		super();
		this.otpMatched = otpMatched;
		this.otpMismatchCount = otpMismatchCount;
	}
	
	public ValidateSmsOtp()
	{
		
	}

/*	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}*/
}
