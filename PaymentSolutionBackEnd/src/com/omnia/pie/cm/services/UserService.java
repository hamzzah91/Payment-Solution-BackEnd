package com.omnia.pie.cm.services;

import java.util.List;

import com.omnia.pie.cm.data.model.SmsOtp;
import com.omnia.pie.cm.data.model.UserInfo;
import com.omnia.pie.cm.data.model.Users;
import com.omnia.pie.cm.ui.model.vtm.UsrManagementUI;
import com.omnia.pie.cm.web.rest.param.SendSmsOtpRequest;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public interface UserService {

	boolean validateUserCredentials(String username,String password);
	boolean createUser(String username,String password,String email,Long userGroupId);
	UserGroupCode getUserGroup(String username);
	Users findUserByUserName(String username);
	UserInfo findUserByPhoneNo(String phoneNo);
	List<UsrManagementUI> listAllUsers();
	boolean saveUserInfo(String phoneNo,String firstName,String lastName);
	boolean saveSmsOtp(SendSmsOtpRequest request,String smsOtp,String uuid);
	boolean SendOtpSmsToSmsGateway(String accountSID, String authToken,String toPhoneNo,String fromPhoneNo,String smsOtp,String messageText,SmsOtp otp);
	UserInfo updateUserInfo(UserInfo user);
	SmsOtp findSavedOtp(String phoneNo,String smsOtp,String uuid);
	SmsOtp updateSmsOtp(SmsOtp otp);
	SmsOtp findSmsOtpByUUID(String UUID);

}
