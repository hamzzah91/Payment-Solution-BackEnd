package com.omnia.pie.cm.services;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.omnia.pie.cm.data.access.SmsOtpDAO;
import com.omnia.pie.cm.data.access.UsaltDAO;
import com.omnia.pie.cm.data.access.UserInfoDAO;
import com.omnia.pie.cm.data.access.UsersDAO;
import com.omnia.pie.cm.data.model.SmsOtp;
import com.omnia.pie.cm.data.model.Usalt;
import com.omnia.pie.cm.data.model.UserGroup;
import com.omnia.pie.cm.data.model.UserInfo;
import com.omnia.pie.cm.data.model.Users;
import com.omnia.pie.cm.ui.model.vtm.UsrManagementUI;
import com.omnia.pie.cm.ui.util.HashHandler;
import com.omnia.pie.cm.web.rest.param.SendSmsOtpRequest;
import com.omnia.pie.cm.web.util.TransactionUtils;
import com.omnia.pie.cm.web.util.TransactionUtils.ResponseCodes;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {
	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());
	private HashHandler hashHandler;
	
	@Autowired
	private UsersDAO usersDao;
	
	@Autowired
	private UserInfoDAO userInfoDao;
	

	@Autowired
	private SmsOtpDAO smsOtpDao;
	
	@Autowired
	private ParameterCheckService parameterCheckService;
	
	@Autowired
	private UsaltDAO usalt;

	@Override
	public boolean validateUserCredentials(String username, String password) {
		// TODO Auto-generated method stub
		List<Users> users = usersDao.findByProperty("Users", "username", username);
		if (users != null && !users.isEmpty()) {
			hashHandler = new HashHandler();
			Users user = users.get(0);
			String fetchedSalt = "";
			for (Usalt u : user.getUsalts())
				fetchedSalt = u.getSalt();

			if (username.equals(user.getUsername())
					&& hashHandler.hash(fetchedSalt, password).equals(user.getPassword())) {
				user.setLastLogin(ZonedDateTime.now());
				usersDao.update(user);
				return true;
			} else
				return false;
		} else
			return false;
	}

	
	
	@Override
	public boolean createUser(String username, String password, String email, Long userGroupId) {
		// TODO Auto-generated method stub
		boolean saveResult = false;
		if (username != null && password != null && email != null && userGroupId != null && !username.isEmpty()
				&& !password.isEmpty() && !email.isEmpty()) {
			List<Users> findUsers = usersDao.findByProperty("Users", "username", username);
			List<Users> findEmail = usersDao.findByProperty("Users", "email", email);
			if ((findUsers == null || findUsers.isEmpty()) && (findEmail == null || findEmail.isEmpty())) {
				Users newUser = new Users();
				newUser.setUsername(username);
				Usalt s = new Usalt();
				hashHandler = new HashHandler();
				s.setSalt(hashHandler.newSalt());
				newUser.setPassword(hashHandler.hash(s.getSalt(), password));
				newUser.setPasswordDate(ZonedDateTime.now());
				newUser.setEmail(email);
				UserGroup group = new UserGroup();
				group.setId(userGroupId);
				newUser.setUserGroup(group);
				try {
					usersDao.save(newUser);
					saveResult = true;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					saveResult = false;
					e.printStackTrace();
				}

				if (saveResult) {
					boolean saltSaveResult = false;
					s.setUsers(newUser);
					try {
						usalt.save(s);
						saltSaveResult = true;
					} catch (Exception e) {
						// TODO Auto-generated catch block
						saltSaveResult = false;
						log.info("can't save the salt for the user :" + newUser.getUsername());
						try {
							throw new Exception(e);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					if (!saltSaveResult) {
						log.info("can't save the salt for the user :" + newUser.getUsername());
						saveResult = false;
					}
				}
			} else {
				log.info("Cant save the new user, username or email already exists");
			}
		} else {
			log.info("Cant save the new user, one or more paramters are empty");
		}
		return saveResult;
	}

	@Override
	public UserGroupCode getUserGroup(final String username) {
		String userGroup = null;
		List<Users> usersList = usersDao.findByProperty("Users", "username", username);
		if (!usersList.isEmpty()){
			Users user = usersList.get(0);
			userGroup = user.getUserGroup().getName();
		}
		return UserGroupCode.valueOf(userGroup);
	}
	
	
	@Override
	public Users findUserByUserName(String username) {
		// TODO Auto-generated method stub
		List<Users> findUsers = usersDao.findByProperty("Users", "username", username);
		if(findUsers != null && !findUsers.isEmpty())
			return findUsers.get(0);
		else return null;
	}

	@Override
	public List<UsrManagementUI> listAllUsers() {
		List<UsrManagementUI> resultList = new ArrayList<UsrManagementUI>();
		List<Users> users = usersDao.findAll();
		UsrManagementUI nUsr = null;
		for (Users usr : users){
			nUsr = new UsrManagementUI();
			nUsr.setUsername(usr.getUsername());
			if (nUsr.getLastLogin() != null)
				nUsr.setLastLogin(nUsr.getLastLogin());
			if (usr.getPasswordDate() != null)
				nUsr.setPasswordDate(usr.getPasswordDate().toLocalDateTime());
			if (usr.getPasswordBlockedUntil() != null)
				nUsr.setBlockedUntil(usr.getPasswordBlockedUntil().toLocalDateTime());
			if (usr.getPasswordBlocked() != null)
				nUsr.setPasswordBlocked(usr.getPasswordBlocked());
			nUsr.setEmail(usr.getEmail());
			nUsr.setUserGroupId(usr.getUserGroup().getId());
			nUsr.setUserGroupName(usr.getUserGroup().getName());
			resultList.add(nUsr);
		}
		return resultList;
	}



	@Override
	public boolean saveUserInfo(String phoneNo, String firstName, String lastName) {
		// TODO Auto-generated method stub
		boolean saveResult = false;
		
		UserInfo info = new UserInfo();
		info.setPhone(phoneNo);
		info.setFirstName(firstName);
		info.setLastName(lastName);
		if(parameterCheckService.isSignUpCheckPassed(info))
		{
		try {
			userInfoDao.save(info);
			saveResult = true;
			log.debug("New user saved");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			saveResult = false;
			e.printStackTrace();
		}
		}
		else
		{
			saveResult = false;	
		}
		return saveResult;
	}


	@Transactional
	@Override
	public boolean saveSmsOtp(SendSmsOtpRequest request,String sms_otp,String uuid) {
		// TODO Auto-generated method stub
		SmsOtp smsotp = new SmsOtp();
		
		
		boolean otpSaveResult = false;
		try {
			
			log.info("Sms OTP: " + sms_otp);
			log.info("UUID: " + uuid);
			if (request != null && uuid != null && sms_otp != null && !uuid.isEmpty() && !sms_otp.isEmpty()) 
			{
				//finding the user with phone No for ID
				List<UserInfo> user = (List<UserInfo>) userInfoDao.findByProperty("UserInfo", "phone", request.getPhoneNo().replaceAll("\\s",""), null);
				log.debug("The id of the user requested :"+user.get(0).getId());
				smsotp = TransactionUtils.setSendSmsOtpParams(uuid, sms_otp, request,user.get(0));
				smsOtpDao.save(smsotp);
				otpSaveResult=true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			otpSaveResult = false;
			log.info("Unable to save record or sms is null: ");
			log.info("SMS: " + smsotp);
			e.printStackTrace();
		}
		return otpSaveResult;
	}



	@Override
	public UserInfo findUserByPhoneNo(String phoneNo) {
		// TODO Auto-generated method stub
		List<UserInfo> findUsers = userInfoDao.findByProperty("UserInfo", "phone", phoneNo);
		if(findUsers != null && !findUsers.isEmpty() && findUsers.size()>0)
			return findUsers.get(0);
		else return null;
	}
	
	@Override
	public boolean SendOtpSmsToSmsGateway(String accountSID, String authToken,String toPhoneNo,String fromPhoneNo,String smsOtp,String messageText,SmsOtp otp)
	{
		Twilio.init(accountSID, authToken);
		boolean messageResult = false;
		Message message = null;
		try {
			message = Message.creator(new PhoneNumber(toPhoneNo),//to
			    new PhoneNumber(fromPhoneNo), //from
			    messageText + smsOtp).create();
			messageResult = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if(message != null)
			{
			log.debug("Error Message :"+message.getErrorMessage());
			log.debug("Message Status : "+ message.getStatus());
			log.debug("SID : "+message.getSid());
			otp.setSmsStatus(message.getStatus().toString());
			otp.setSmsSid(message.getSid());
			smsOtpDao.update(otp);
			}
			else
			{
				log.debug("message send failed , updating otp with failure values");
				/*otp.setSmsStatus("FAILURE");
				smsOtpDao.update(otp);*/
			}
			e.printStackTrace();
			messageResult = false;
		}
		if(message != null)
		{
		log.debug("Error Message :"+message.getErrorMessage());
		log.debug("Message Status : "+ message.getStatus());
		log.debug("SID : "+message.getSid());
		otp.setSmsStatus(message.getStatus().toString());
		otp.setSmsSid(message.getSid());
		smsOtpDao.update(otp);
		}
		return messageResult;
	}



	@Override
	public UserInfo updateUserInfo(UserInfo info) {
		// TODO Auto-generated method stub
		boolean saveResult = false;
		UserInfo user = new UserInfo();
		
		if(parameterCheckService.isSignUpCheckPassed(info))
		{
		try {
		    user = userInfoDao.update(info);
			saveResult = true;
			log.debug("User updated : "+ user.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			saveResult = false;
			e.printStackTrace();
		}
		}
		else
		{
			saveResult = false;	
		}
		return user;
	}
	
	
	@Override
	public SmsOtp updateSmsOtp(SmsOtp otp) {
		// TODO Auto-generated method stub
		boolean saveResult = false;
		SmsOtp smsOtp = new SmsOtp();
		
		if(otp != null)
		{
		try {
			smsOtp = smsOtpDao.update(otp);
			saveResult = true;
			log.debug("smsOtp updated : "+ smsOtp.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			saveResult = false;
			e.printStackTrace();
		}
		}
		else
		{
			saveResult = false;	
		}
		return smsOtp;
	}



	@Override
	public SmsOtp findSavedOtp(String phoneNo, String smsOtp, String uuid) {
		// TODO Auto-generated method stub
		UserInfo user = findUserByPhoneNo(phoneNo);
		SmsOtp otp = null;
		if(user != null)
		{
		log.debug("Finding Saved OTP :"+user.getId());
		List<SmsOtp> smsOtpLists = smsOtpDao.findByProperty("SmsOtp", "userId", user);
		if(smsOtpLists.size()>0)
		{
		List<SmsOtp> reverseList = Lists.reverse(smsOtpLists); 
		for(SmsOtp otps: reverseList)
		{	
			if(otps.getUuid().equals(uuid) && otps.getOtp().equals(smsOtp))
			{
				otp = otps;
				break;
			}
		}
		}
		else
		{
			return null;
		}
		}
		else
		{	log.debug("user not found to fetch otp");
			return null;
		}
		return otp;
	}



	@Override
	public SmsOtp findSmsOtpByUUID(String UUID) {
		// TODO Auto-generated method stub
		SmsOtp otp = new SmsOtp();
		log.debug("Finding Saved OTP by UUID");
		try {
			 otp = smsOtpDao.findSmsOtpByUUID(UUID);
			if (otp != null) {
				return otp;
			} else {
				log.debug("Null response for finding sms otp in db with UUID");
				return null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.debug("Excpetion occurred while finding sms otp", e);
			return null;
		}
	}
}
