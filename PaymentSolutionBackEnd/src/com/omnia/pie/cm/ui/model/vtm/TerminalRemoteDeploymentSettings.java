package com.omnia.pie.cm.ui.model.vtm;

import java.time.LocalDateTime;

import com.omnia.pie.cm.data.model.Customer;
import com.omnia.pie.cm.data.model.TerminalInfo;

public class TerminalRemoteDeploymentSettings{

	private Customer customer;
	private String version;
	private String fileName;
	private String filePath;
	private String fileType;
	private String checksum;
	private String installed;
	private LocalDateTime dateInstalled;
	private String jobTicket;
	private String status;
	private String terminalId;
	private String scheduleTime;
	private Long id;
	private TerminalInfo terminalInfo;

	public TerminalInfo getTerminalInfo() {
		return terminalInfo;
	}
	public void setTerminalInfo(TerminalInfo terminalInfo) {
		this.terminalInfo = terminalInfo;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTerminalId() {
		return terminalId;
	}
	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}
	public String getScheduleTime() {
		return scheduleTime;
	}
	public void setScheduleTime(String scheduleTime) {
		this.scheduleTime = scheduleTime;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getChecksum() {
		return checksum;
	}
	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}
	public String isInstalled() {
		return installed;
	}
	public void setInstalled(String installed) {
		this.installed = installed;
	}
	public LocalDateTime getDateInstalled() {
		return dateInstalled;
	}
	public void setDateInstalled(LocalDateTime dateInstalled) {
		this.dateInstalled = dateInstalled;
	}
	public String getJobTicket() {
		return jobTicket;
	}
	public void setJobTicket(String jobTicket) {
		this.jobTicket = jobTicket;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
