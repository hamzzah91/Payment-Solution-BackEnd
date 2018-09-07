package com.omnia.pie.cm.web.rest.param;

public class AgentJobReqParam {

	private String token;
	private String agentId;
	private String jobTicket;
	private String referenceCode;
	private String message;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getAgentId() {
		return agentId;
	}
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}
	public String getJobTicket() {
		return jobTicket;
	}
	public void setJobTicket(String jobTicket) {
		this.jobTicket = jobTicket;
	}
	public String getReferenceCode() {
		return referenceCode;
	}
	public void setReferenceCode(String referenceCode) {
		this.referenceCode = referenceCode;
	}
	
	public String toString(){
		return "token=" + token + ", agentId=" + agentId + ", jobTicket=" + jobTicket + ", referenceCode=" + referenceCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
