package com.omnia.pie.cm.services.model;

public class CassetteBalance {

	private String type;
	private String name;
	private String denomination;
	private int balance;
	private int lowMargin;
	
	public CassetteBalance(){}

	public CassetteBalance(String type, String name, String denomination, int balance, int lowMargin){
		this.type = type;
		this.name = name;
		this.denomination = denomination;
		this.balance = balance;
		this.lowMargin = lowMargin;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDenomination() {
		return denomination;
	}
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public int getLowMargin() {
		return lowMargin;
	}

	public void setLowMargin(int lowMargin) {
		this.lowMargin = lowMargin;
	}
	
}
