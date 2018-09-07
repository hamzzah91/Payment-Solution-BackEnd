package com.omnia.pie.cm.web.rest.param;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmailNotificationRequest {

	@JsonProperty("TerminalDetails")
	protected String terminalDetails;
	
	@JsonProperty("Branch")
	protected String branch;
	
	@JsonProperty("EmailTypeCode")
	private String emailTypeCode;

	@JsonProperty("ErrorCode")
	protected String errorCode;

	@JsonProperty("ErrorDescription")
	protected String errorDescription;

	@JsonProperty("Troubleshoot")
	protected String troubleshoot;

	@JsonProperty("Device")
	protected String device;

	@JsonProperty("ErrorTimestamp")
	protected String errorTimestamp;

	@JsonProperty("Category")
	protected String category;
	
	@JsonProperty("Ticket")
	protected String ticket;
	
	@JsonProperty("Priority")
	protected String priority;

	@JsonProperty("Level")
	protected String level;	

	@JsonProperty("EmailBody")
	protected String emailBody;
	
	@JsonProperty("EmailSubject")
	protected String emailSubject;
	
	public EmailNotificationRequest(){}
	
	public EmailNotificationRequest(String emailTypeCode){
		this.emailTypeCode = emailTypeCode;
	}
	
	public String getEmailTypeCode() {
		return emailTypeCode;
	}

	public void setEmailTypeCode(String emailTypeCode) {
		this.emailTypeCode = emailTypeCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public String getTroubleshoot() {
		return troubleshoot;
	}

	public void setTroubleshoot(String troubleshoot) {
		this.troubleshoot = troubleshoot;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getErrorTimestamp() {
		return errorTimestamp;
	}

	public void setErrorTimestamp(String errorTimestamp) {
		this.errorTimestamp = errorTimestamp;
	}

	public String getTerminalDetails() {
		return terminalDetails;
	}

	public void setTerminalDetails(String terminalDetails) {
		this.terminalDetails = terminalDetails;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getEmailBody() {
		return emailBody;
	}

	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}

	public String getEmailSubject() {
		return emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}
	
	
}
