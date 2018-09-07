package com.omnia.pie.cm.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omnia.pie.cm.access.utils.LoggedUser;
import com.omnia.pie.cm.data.model.Channel;
import com.omnia.pie.cm.data.model.Customer;
import com.omnia.pie.cm.services.UserService;

/**
 * @author M Louie
 *
 */

@Service ("currentUser")
public class CurrentUser {

	@Autowired
	private UserService userService;
	
	public Channel getUserChannel(){
		return null;/*
		CustomerUsers cUsers = new CustomerUsers();
		Channel channelObj = new Channel();
		if(LoggedUser.hasUser())
		{
			cUsers= userService.findCustomerByUser(LoggedUser.user());
			Channel channel =  userService.findChannelById(cUsers.getCustomer().getChannel().getId());
			channelObj.setId(cUsers.getCustomer().getChannel().getId());
			channelObj.setChannelName(channel.getChannelName());
		}
		

		// TODO: fix this
		// Comment it out when terminal is visible
		// hardcoded for now, in AHB, there will only be one channel which is VTM
		if (channelObj.getChannelName() == null){
			channelObj.setId(2L);
			channelObj.setChannelName("VTM");
			channelObj.setChannelLongName("Virtual Teller Machine");
		}
		

		return channelObj;
	*/}
	
	public Customer getUserCustomer(){
		return null;/*
		Customer customerObj = new Customer();
		CustomerUsers cUsers = new CustomerUsers();

		if(LoggedUser.hasUser())
		{
			cUsers= userService.findCustomerByUser(LoggedUser.user());
			customerObj.setId(cUsers.getCustomer().getId());
			customerObj.setName(cUsers.getCustomer().getName());
			customerObj.setShortName(cUsers.getCustomer().getShortName());
		}
		
		// TODO: fix this
		// Comment it out when terminal is visible
		// hardcoded for now, in AHB, there will only be one customer which is AHB
		if (customerObj.getName() == null){
			customerObj.setId(1L);
			customerObj.setName("Al Hilal Bank");
			customerObj.setShortName("AHB");
		}
		
		
		return customerObj;
	*/}
}
