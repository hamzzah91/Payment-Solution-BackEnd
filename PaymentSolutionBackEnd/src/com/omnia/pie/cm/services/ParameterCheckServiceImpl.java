package com.omnia.pie.cm.services;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.omnia.pie.cm.data.model.Channel;
import com.omnia.pie.cm.data.model.Customer;
import com.omnia.pie.cm.data.model.TerminalInfo;
import com.omnia.pie.cm.data.model.UserInfo;

/**
 * @author M Louie
 *
 */

@Service ("parameterCheckService")
public class ParameterCheckServiceImpl implements ParameterCheckService{

	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());
	private DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	
	@Override
	public boolean isChannelCheckPassed(final Channel channel) {
		
		if (channel != null && channel.getId() != null && channel.getId() > 0 && channel.getChannelName() != null)
			return true;
		else{
			log.error("Channel contains null/empty value and not a valid Channel data");
			return false;
		}
			
	}

	@Override
	public boolean isCustomerCheckPassed(final Customer customer) {
		
		if (customer != null && customer.getId() != null && customer.getId() > 0 && customer.getName() != null)
			return true;
		else{
			log.error("Customer contains null/empty value and not a valid Customer data");
			return false;
		}
	}

	@Override
	public boolean isTerminalCheckPassed(final TerminalInfo terminal) {
		
		if (terminal.getTerminalId() != null)
			return true;
		else{
			log.error("TerminalInfo contains null/empty value and not a valid TerminalInfo data");
			return false;
		}
	}

	@Override
	public boolean isStringNotEmptyCheckPassed(final String stringValue) {
		if(stringValue != null && !stringValue.isEmpty())
			return true;
		else
		{
			log.error("{} : isStringNotEmptyCheckPassed failed", stringValue);
			return false;
		}
	}

	@Override
	public boolean isListNullOrEmptyCheckPassed(List<?> list) {
		if (list != null && list.size() > 0)
			return true;
		else{
			log.error("{} : isListNullOrEmptyCheckPassed failed", list);
			return false;
		}
	}

	@Override
	public boolean validatePathIsTruePath(String path) {
		//if (path != null && (path.contains("\\") || path.contains("/")))
		if (path != null && !path.isEmpty())
		return true;
		else
		{
			log.error("{} : is not a valid path", path);
			return false;
		}
	}

	@Override
	public boolean validateTimeScheduleIsTime(String time) {
		try {
			LocalTime.parse(time, timeFormatter);
		} catch (Exception e) {
			log.error("{} : is not a valid time", time);
			return false;
		}
		return true;
	}

	@Override
	public boolean validateSftpPort(String port) {
		// TODO Auto-generated method stub
		if(port != null && !port.isEmpty())
		return true;
		else
		{
			log.error("{} : is not a valid port", port);

		return false;
		}
		}

	@Override
	public boolean validateSftpUser(String user) {
		// TODO Auto-generated method stub
		if (user != null && !user.isEmpty())
			return true;
		else{
			log.error("{} : is not a valid user", user);
			return false;
		}
		}

	@Override
	public boolean validateSftpPassword(String password) {
		// TODO Auto-generated method stub
		if (password != null && !password.isEmpty())
			return true;
		else{
			log.error("{} : is not a valid password", password);
			return false;
		}	}

	@Override
	public boolean isObjectNullCheckPassed(Object object) {
		return (object == null ? false: true);
	}

	@Override
	public boolean isSignUpCheckPassed(UserInfo userInfo) {
		// TODO Auto-generated method stub
		if (userInfo.getPhone() != null && userInfo.getFirstName() != null && userInfo.getLastName() != null
				&& !userInfo.getPhone().isEmpty() && !userInfo.getFirstName().isEmpty() && !userInfo.getLastName().isEmpty())
			return true;
		else{
			log.error("UserInfo contains empty/null values so its not a valid");
			return false;
		}
	}
}
