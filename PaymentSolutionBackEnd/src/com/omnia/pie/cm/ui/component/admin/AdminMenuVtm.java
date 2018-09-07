package com.omnia.pie.cm.ui.component.admin;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * 
 * @author M Louie
 * 
 */

@SessionScoped
@ManagedBean(name="adminMenuVtm")
public class AdminMenuVtm {

	private List<String> customers;

	public List<String> getCustomers() {
		customers = dataStub();
		return customers;
	}

	public void setCustomers(List<String> customers) {
		this.customers = customers;
	}
	
	private List<String> dataStub(){
		List<String> list = new ArrayList<String>();
		list.add("Abu Dhabi Islamic Bank");
		list.add("Al Hilal Bank");
		list.add("Qatar Islamic Bank");
		list.add("Sharjah Islamic Bank");
		return list;
	}
}
