package com.omnia.pie.cm.web.rest.param;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TerminalRequestPieDb {

	@JsonProperty("Terminal")
	protected TerminalPermissions terminalPermissions;

	@JsonProperty("TerminalId")
	protected String terminalId;
	
	@JsonProperty("TerminalLocation")
	protected String terminalLocation;
	
	@JsonProperty("TerminalCity")
	protected String terminalCity;
	
	@JsonProperty("CurrencyCode")
	protected String currencyCode;
	
	@JsonProperty("SerialNumber")
	protected String serialNumber;
	
	@JsonProperty("MerchantId")
	protected String merchantId;

	@JsonProperty("AcquiringInstitutionId")
	protected String acquiringInstitutionId;

	

	
	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getAcquiringInstitutionId() {
		return acquiringInstitutionId;
	}

	public void setAcquiringInstitutionId(String acquiringInstitutionId) {
		this.acquiringInstitutionId = acquiringInstitutionId;
	}

	public TerminalPermissions getTerminalPermissions() {
		return terminalPermissions;
	}

	public void setTerminalPermissions(TerminalPermissions terminalPermissions) {
		this.terminalPermissions = terminalPermissions;
	}

	public String getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	public String getTerminalLocation() {
		return terminalLocation;
	}

	public void setTerminalLocation(String terminalLocation) {
		this.terminalLocation = terminalLocation;
	}

	public String getTerminalCity() {
		return terminalCity;
	}

	public void setTerminalCity(String terminalCity) {
		this.terminalCity = terminalCity;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	
}
