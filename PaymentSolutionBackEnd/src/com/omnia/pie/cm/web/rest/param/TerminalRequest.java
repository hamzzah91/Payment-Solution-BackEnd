package com.omnia.pie.cm.web.rest.param;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TerminalRequest implements java.io.Serializable{

	private static final long serialVersionUID = -6015610520601409109L;
	
	@JsonProperty("TerminalId")
	 private String terminalId;
	
	@JsonProperty("BranchId")
     private String branchId;
     
	@JsonProperty("Platform")
    private String platform;
   
     
	public String getPlatform() {
		return platform;
	}


	public void setPlatform(String platform) {
		this.platform = platform;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getTerminalId() {
		return terminalId;
	}


	public String getBranchId() {
		return branchId;
	}


	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}


	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}


	@Override
	public String toString() {
		return "Terminals [terminalId=" + terminalId + ", branchId=" + branchId + ", platform=" + platform +"]";
	}


	public TerminalRequest(String terminalId, String branchId) {
		super();
		this.terminalId = terminalId;
		this.branchId = branchId;
	}
     
    public TerminalRequest()
    {
    	
    }



}
