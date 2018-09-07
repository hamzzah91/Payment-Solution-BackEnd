package com.omnia.pie.cm.services;

import java.util.List;

import com.omnia.pie.cm.data.model.Channel;
import com.omnia.pie.cm.data.model.Customer;
import com.omnia.pie.cm.data.model.TerminalInfo;
import com.omnia.pie.cm.data.model.UserInfo;


/**
 * @author M Louie
 *
 */

public interface ParameterCheckService {


	boolean isChannelCheckPassed(Channel channel);
	boolean isCustomerCheckPassed(Customer channel);
	boolean isTerminalCheckPassed(TerminalInfo terminal);
	boolean isStringNotEmptyCheckPassed(String stringValue);
	boolean isListNullOrEmptyCheckPassed(List<?> list);
	boolean isObjectNullCheckPassed(Object object);
	boolean validatePathIsTruePath(String path);
	boolean validateTimeScheduleIsTime(String time);
	boolean validateSftpPort(String port);
	boolean validateSftpUser(String user);
	boolean validateSftpPassword(String password);
	boolean isSignUpCheckPassed(UserInfo userInfo);
}
