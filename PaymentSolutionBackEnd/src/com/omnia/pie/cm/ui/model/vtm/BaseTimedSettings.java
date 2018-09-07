package com.omnia.pie.cm.ui.model.vtm;

import java.util.Date;

public class BaseTimedSettings {
	
	protected String terminal;
	protected String occurence;
	protected Date uploadSchedule;
	protected int hours;
	protected int minutes;
	protected int seconds;
	
	public String getTerminal() {
		return terminal;
	}
	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}
	public Date getUploadSchedule() {
		return uploadSchedule;
	}
	public void setUploadSchedule(Date uploadSchedule) {
		this.uploadSchedule = uploadSchedule;
	}
	public String getOccurence() {
		return occurence;
	}
	public void setOccurence(String occurence) {
		this.occurence = occurence;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	public int getSeconds() {
		return seconds;
	}
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	
}
