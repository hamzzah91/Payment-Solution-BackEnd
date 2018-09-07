package com.omnia.pie.cm.web.rest.param;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RulesResponse {

	@JsonProperty("Notification")
	private String notification;
	
	@JsonProperty("EmailTypeCode")
	private String emailTypeCode;
	
	@JsonProperty("PriorityLevel")
	private String priorityLevel;
	
	@JsonProperty("MaintenanceLevelCode")
	private String maintenanceLevelCode;
	
	@JsonProperty("MaintenanceLevel")
	private String maintenanceLevel;
	
	@JsonProperty("Description")
	private String description;
	
	@JsonProperty("Troubleshooting")
	private String troubleshooting;
	
	@JsonProperty("Category")
	private String category;

	@JsonProperty("Device")
	private String device;
	
	
	public String getNotification() {
		return notification;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}

	public String getEmailTypeCode() {
		return emailTypeCode;
	}

	public void setEmailTypeCode(String emailTypeCode) {
		this.emailTypeCode = emailTypeCode;
	}

	public String getPriorityLevel() {
		return priorityLevel;
	}

	public void setPriorityLevel(String priorityLevel) {
		this.priorityLevel = priorityLevel;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTroubleshooting() {
		return troubleshooting;
	}

	public void setTroubleshooting(String troubleshooting) {
		this.troubleshooting = troubleshooting;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getMaintenanceLevelCode() {
		return maintenanceLevelCode;
	}

	public void setMaintenanceLevelCode(String maintenanceLevelCode) {
		this.maintenanceLevelCode = maintenanceLevelCode;
	}

	public String getMaintenanceLevel() {
		return maintenanceLevel;
	}

	public void setMaintenanceLevel(String maintenanceLevel) {
		this.maintenanceLevel = maintenanceLevel;
	}
	
}
