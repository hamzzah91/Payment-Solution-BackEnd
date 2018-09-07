package com.omnia.pie.cm.services.model;

import java.time.LocalDateTime;


/**
 * @author M Louie
 *
 */

public class AgentJobQueueParam {

	private String terminal;
	private String serverAgent;
	private String jobType;
	private String jobTicket;
	private String referenceCode;
	private String scheduleCron;
	private LocalDateTime schedule;
	private boolean recurringJob;
	
	public String getTerminal() {
		return terminal;
	}
	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}
	public String getServerAgent() {
		return serverAgent;
	}
	public void setServerAgent(String serverAgent) {
		this.serverAgent = serverAgent;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
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
	public String getScheduleCron() {
		return scheduleCron;
	}
	public void setScheduleCron(String scheduleCron) {
		this.scheduleCron = scheduleCron;
	}
	public LocalDateTime getSchedule() {
		return schedule;
	}
	public void setSchedule(LocalDateTime schedule) {
		this.schedule = schedule;
	}
	public boolean isRecurringJob() {
		return recurringJob;
	}
	public void setRecurringJob(boolean recurringJob) {
		this.recurringJob = recurringJob;
	}
	
}
