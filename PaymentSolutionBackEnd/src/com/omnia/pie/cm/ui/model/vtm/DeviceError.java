package com.omnia.pie.cm.ui.model.vtm;

public class DeviceError {

	private String errorCode;
	private String device;
	private String description;
	private String troubleshootingSuggestion;
	private String category;
	private String maintenanceLevel;
	private String priority;
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	public String getTroubleshootingSuggestion() {
		return troubleshootingSuggestion;
	}
	public void setTroubleshootingSuggestion(String troubleshootingSuggestion) {
		this.troubleshootingSuggestion = troubleshootingSuggestion;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getMaintenanceLevel() {
		return maintenanceLevel;
	}
	public void setMaintenanceLevel(String maintenanceLevel) {
		this.maintenanceLevel = maintenanceLevel;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	
}
