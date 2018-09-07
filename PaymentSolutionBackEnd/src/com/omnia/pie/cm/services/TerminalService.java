package com.omnia.pie.cm.services;

import java.util.List;

import com.cronutils.model.Cron;
import com.omnia.pie.cm.data.model.Channel;
import com.omnia.pie.cm.data.model.Customer;
import com.omnia.pie.cm.data.model.TerminalInfo;
import com.omnia.pie.cm.ui.model.vtm.TerminalInformation;

/**
 * @author M Louie
 *
 */

public interface TerminalService {

	List<String> listTerminalNamesByChannelCustomer(Channel channel, Customer customer);
	
	List<TerminalInfo> listTerminalByChannelCustomer(Channel channel, Customer customer);
	List<TerminalInfo> listTerminalByChannelCustomer(Channel channel, Customer customer, boolean evictFromSession);
	
	
	Cron buildCron(String occurence, String scheduledTime);
	
}
