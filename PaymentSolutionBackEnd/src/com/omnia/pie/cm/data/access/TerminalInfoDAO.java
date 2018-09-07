package com.omnia.pie.cm.data.access;

import java.util.List;

import com.omnia.pie.base.dao.BaseDAO;
import com.omnia.pie.cm.data.model.Channel;
import com.omnia.pie.cm.data.model.Customer;
import com.omnia.pie.cm.data.model.TerminalInfo;

/**
 * @see com.omnia.pie.cm.data.model.TerminalInfo
 * @author M Louie
 */

public interface TerminalInfoDAO extends BaseDAO<TerminalInfo> {
	
	List<String> searchTerminalNamesByChannelCustomer(Channel channel, Customer customer);
	List<TerminalInfo> searchTerminalByChannelCustomer(Channel channel, Customer customer);
	TerminalInfo searchByTerminalId(String terminalId);
	public List<TerminalInfo> findByProperty(String propertyName, Object value, int... rowStartIdxAndCount);

}