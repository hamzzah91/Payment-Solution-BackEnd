package com.omnia.pie.cm.web.rest;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.web.bind.annotation.RequestBody;

import com.omnia.pie.cm.data.model.SmsOtp;
import com.omnia.pie.cm.data.model.UserInfo;
import com.omnia.pie.cm.models.snapshot.terminal.v2.TransactionData;
import com.omnia.pie.cm.services.ParameterCheckService;
import com.omnia.pie.cm.services.UserService;
import com.omnia.pie.cm.web.rest.param.ErrorResponse;
import com.omnia.pie.cm.web.rest.param.RestMethodResult;
import com.omnia.pie.cm.web.rest.param.SendSmsOtpRequest;
import com.omnia.pie.cm.web.rest.param.SendSmsOtpResponse;
import com.omnia.pie.cm.web.rest.param.ValidateSmsOtpRequest;
import com.omnia.pie.cm.web.rest.param.ValidateSmsOtpResponse;
import com.omnia.pie.cm.web.util.TransactionUtils;
import com.omnia.pie.cm.web.util.TransactionUtils.ResponseCodes;
import com.omnia.pie.cm.web.util.TransactionUtils.ResponseCodesDescription;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


@Path(value = "/")
public class AuthenticationController {
	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	/*@Autowired
	private AgentJobService agentJobService;
*/	
	@Autowired
	private ParameterCheckService parameterCheckService;
	
	@Autowired
	private UserService userService;
	private Properties propertiesUtil;
	private String smsGatewayPhoneNo;
	private String smsGatewayAccountSID;
	private String smsGatewayAuthToken;
	private String smsMessageText;
	
public AuthenticationController() {
		
		try {
			log.debug("Reading properties file for business rule endpoint and notification service endpoint..");
			Resource resource = new ClassPathResource("/remitnow.properties");
			propertiesUtil = PropertiesLoaderUtils.loadProperties(resource);
			smsGatewayPhoneNo = propertiesUtil.getProperty("sms.gateway.phone.no");
			smsGatewayAccountSID = propertiesUtil.getProperty("sms.gateway.account.ssid");
			smsGatewayAuthToken = propertiesUtil.getProperty("sms.gateway.account.auth.token");
			smsMessageText = propertiesUtil.getProperty("sms.gateway.message.text");

		}catch (IOException e) {
			e.printStackTrace();
		}
}
    @POST
	@Path("/signUp")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public SendSmsOtpResponse signUp(final SendSmsOtpRequest request) {
	    
    	
    	log.debug("SignUpParam : {}", request);
	    UserInfo existingUserInfo = new UserInfo();
	    SendSmsOtpResponse response = new SendSmsOtpResponse();
	    boolean saveNewUser = false;
	    String phoneNumber;
	    if(request!= null && request.getPhoneNo() != null && request.getFirstName()!= null && request.getLastName() != null
	    		&& !request.getFirstName().isEmpty() && !request.getLastName().isEmpty())
	    {
	    	//removing while spaces from phone no
	    	phoneNumber=request.getPhoneNo().replaceAll("\\s","");
	    //check if the user already signed up
	    	existingUserInfo = userService.findUserByPhoneNo(phoneNumber);
	    	if(existingUserInfo != null)
	    	{
	    		existingUserInfo.setFirstName(request.getFirstName());
	    		existingUserInfo.setLastName(request.getLastName());
	    		existingUserInfo = userService.updateUserInfo(existingUserInfo);
	    		log.debug("update result for fname and lname is :"+ existingUserInfo.getFirstName() + " Last Name: " +existingUserInfo.getLastName());
	    	}
	    	
	    //if user does not exists already then save it as the new user

	    	if(existingUserInfo == null)
	    	{
	    		log.debug("User does not exists");
	    		saveNewUser = userService.saveUserInfo(phoneNumber, request.getFirstName(), request.getLastName());
	    	}
	    	else
	    	{
	    		log.debug("User already exists " + existingUserInfo.getPhone() + " First Name :"+existingUserInfo.getFirstName());
	    	}
	    	if(saveNewUser || (existingUserInfo != null && existingUserInfo.getPhone() != null))
	    	{
	    		String uuid = TransactionUtils.generateUUID();
	    		String sms_otp="";
	    		try {
	    			sms_otp = TransactionUtils.generateSmsOtp();
	    		} catch (InvalidKeyException e1) {
	    			// TODO Auto-generated catch block
	    			log.info("Unable to generate sms otp or sms is null: ");
	    			log.info("SMS: " + sms_otp);
	    			response.setErrorRsp(TransactionUtils.getSystemMalfunctionError());
	    			log.debug(e1.toString());
	    			return response;
	    		} catch (NoSuchAlgorithmException e1) {
	    			// TODO Auto-generated catch block
	    			log.info("Unable to generate sms otp or sms is null: ");
	    			log.info("SMS: " + sms_otp);
	    			response.setErrorRsp(TransactionUtils.getSystemMalfunctionError());
	    			log.debug(e1.toString());
	    			return response;
	    		}
	    		if(sms_otp !=null && uuid != null && !sms_otp.isEmpty() && !uuid.isEmpty())
	    		{
	    			boolean savedotpResult = userService.saveSmsOtp(request,sms_otp,uuid);
	    			log.debug("Otp Saved " + savedotpResult);
	    			if(savedotpResult)
	    			{
	    				SmsOtp savedOtp = userService.findSavedOtp(phoneNumber, sms_otp, uuid);
	    				if(savedOtp != null)
	    				{
	    					try {
	    						log.info("Sending OTP to SMS Gateway");	
	    						boolean sendSmsResult = userService.SendOtpSmsToSmsGateway(smsGatewayAccountSID, smsGatewayAuthToken, phoneNumber, smsGatewayPhoneNo,sms_otp, smsMessageText,savedOtp);
	    						log.info("Sending SMS Result : "+sendSmsResult);
	    						if(sendSmsResult)
	    						{
	    							response = TransactionUtils.setSmsOtpResponse(uuid, sms_otp);

	    						}
	    						else
	    						{
	    							response.setErrorRsp(TransactionUtils.getProcessingError());
	    							log.info("Error while sending sms otp to sms gateway");
	    							savedOtp.setSmsStatus("FAILURE");
	    							savedOtp.setResponseCode(ResponseCodes._999_ERROR);
		    						userService.updateSmsOtp(savedOtp);
	    							return response;
	    						}
	    					} catch (Exception e) {
	    						// TODO Auto-generated catch block
	    						response.setErrorRsp(TransactionUtils.getSystemMalfunctionError());
	    						log.info("Error while sending sms otp to sms gateway");
	    						savedOtp.setSmsStatus("FAILURE");
	    						savedOtp.setResponseCode(ResponseCodes._997_SYSTEM_MALFUNCTION);
	    						userService.updateSmsOtp(savedOtp);
	    						e.printStackTrace();
	    						return response;

	    					}
	    				}
	    				else
	    				{
	    					// TODO Auto-generated catch block
	    					response.setErrorRsp(TransactionUtils.getSystemMalfunctionError());
	    					log.info("Error while sending fetching the saved otp");
	    					return response;

	    				}
	    			}
	    			else
	    			{

	    				response.setErrorRsp(TransactionUtils.getSystemMalfunctionError());
	    				log.info("Unable to save sms otp or uuid. " + "Sms otp or uuid is null: ");
	    				return response;

	    			}
	    		}
	    		else
	    		{
					response.setErrorRsp(TransactionUtils.getSystemMalfunctionError());
					log.info("Unable to generate sms otp or uuid. " + "Sms otp or uuid is null: ");
					log.info("Sms OTP: " + sms_otp);
					log.info("UUID: " + uuid);				
	    		}
	    	}
	    	else
	    	{

	    		response.setErrorRsp(TransactionUtils.getSystemMalfunctionError());
	    		log.info("User Update was not successful");
	    		return response;

	    	}
	    }
	    else
	    {

	    	response.setErrorRsp(TransactionUtils.getMissingMandatoryFieldsError());
	    	log.info("Parameters are empty");
	    	return response;

	    }
	    return response;

    }
    @POST
   	@Path("/validatesmsotp")
   	@Consumes(MediaType.APPLICATION_JSON)
   	@Produces(MediaType.APPLICATION_JSON)
    public ValidateSmsOtpResponse requestValidateSmsOtp(@RequestBody ValidateSmsOtpRequest request) {

    	log.debug("validatesmsotp : {}", request);

		TransactionData transaction_data = new TransactionData();
		ValidateSmsOtpResponse response = new ValidateSmsOtpResponse();
		String phoneNumber = null;
		try {
			// Check for Terminal info

				if (request.getOtp() != null && request.getUuid() != null && !StringUtils.isEmpty(request.getOtp())
						&& !StringUtils.isEmpty(request.getUuid())) {
					// Find SMS OTP in DB
					SmsOtp otp = new SmsOtp();
					phoneNumber=request.getPhoneNo().replaceAll("\\s","");

					otp = userService.findSavedOtp(phoneNumber, request.getOtp(), request.getUuid());

					if (otp != null) {
						// Found an sms otp match
						log.debug("OTP Found: "+otp.toString());
						if (otp.getValidated() == 0) {
							// TODO: Implement time check of VTM

							// SMS not validated
							// Insert validate record in db
							
								otp = TransactionUtils.setOtpMatched(otp);
								SmsOtp updatedOtp = userService.updateSmsOtp(otp);
								if(updatedOtp !=null)
								{
								response = TransactionUtils.getValidateSmsOtpResponse(otp, true);
								return response;
								}
								else
								{
									response.setErrorRsp(TransactionUtils.getSystemMalfunctionError());
									log.info("Error updating the validation field for sms otp");
									return response;
									
								}
							
						} else {
							// SMS already validated
							response = TransactionUtils.getAlreadyValidateSmsOtpResponse(otp);
							log.info("SMS OTP Already Validated: " + otp.toString());
							return response;
						}
					} else {
						log.info("Unable to find OTP using otp & UUID. Searching for OTP using UUID");
						otp = userService.findSmsOtpByUUID(request.getUuid());
						if (otp != null) {
							log.info("Found OTP using UUID");
							int mismatchCount = otp.getMismatchCount();
							mismatchCount += 1;
							otp.setMismatchCount(mismatchCount);

							// Updating SMS OTP mismatch count
							log.info("Incrementing mismatch count and updating SMS OTP");
							otp = userService.updateSmsOtp(otp);
							if (otp != null) {
								log.info("Mismatch count successfully updated");
								// Checking for successful DB update
								response = TransactionUtils.getValidateSmsOtpResponse(otp, false);
								return response;
							} else {
								response.setErrorRsp(TransactionUtils.getSystemMalfunctionError());
								log.info("SMS OTP mismatch count update was not successful: "
										+ transaction_data.toString());
								return response;
							}
						} else {
							response.setErrorRsp(TransactionUtils.getSystemMalfunctionError());
							log.info("Finding SMS OTP with UUID was not successful");
							return response;
						}
					}
				} else {
					response.setErrorRsp(TransactionUtils.getMissingMandatoryFieldsError());
					log.info(ResponseCodesDescription._996_MISSING_MANDATORY_FIELDS
							+ ": SMS OTP Parameters are missing");
					return response;
				}
		} catch (Exception e) {
			response.setErrorRsp(TransactionUtils.getProcessingError());
			log.info("An error occurred while processing request: ", e);
			return response;
		}
	}
    
    /*
	@POST
	@Path("/agentAcknowledge")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RestMethodResult updateAgentAcknowledge(final AgentJobReqParam param) {
	    log.debug("updateAgentAcknowledge : {}", param);

	    AgentJobNotificationParam notificationParam = new AgentJobNotificationParam();
	    notificationParam.processRestRequestParam(param);
	    boolean isSuccess = agentJobService.markAgentJobAsAcknowledgementNotificationReceived(notificationParam);
	    
	    RestMethodResult result = new RestMethodResult();
	    result.setSuccess(isSuccess);
	    if(isSuccess){
	    	result.setStatus("SUCCESS");
	    	result.setMessage("Agent Notified");
	    }else{
	    	result.setStatus("FAILED");
	    	result.setMessage("Unable to perform the action");
	    }
	    return result;
	}


	@POST
	@Path("/agentStartedGettingData")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RestMethodResult updateAgentStartedGettingData(final AgentJobReqParam param) {
	    log.debug("updateAgentStartedGettingData : {}", param);

	    AgentJobNotificationParam notificationParam = new AgentJobNotificationParam();
	    notificationParam.processRestRequestParam(param);
	    boolean isSuccess = agentJobService.markAgentJobAsStartedGettingDataNotificationReceived(notificationParam);
	    
	    RestMethodResult result = new RestMethodResult();
	    result.setSuccess(isSuccess);
	    if(isSuccess){
	    	result.setStatus("SUCCESS");
	    	result.setMessage("Agent Notified");
	    }else{
	    	result.setStatus("FAILED");
	    	result.setMessage("Unable to perform the action");
	    }
	    return result;
	}

	@POST
	@Path("/jobExecutionError")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RestMethodResult jobExecutionError(final AgentJobReqParam param) {
	    log.debug("jobExecutionError : {}", param);

	    AgentJobNotificationParam notificationParam = new AgentJobNotificationParam();
	    notificationParam.processRestRequestParam(param);
	    String errorMessage = param.getMessage();
	    boolean isSuccess = agentJobService.agentJobExecutionError(notificationParam, errorMessage);
	    
	    RestMethodResult result = new RestMethodResult();
	    result.setSuccess(isSuccess);
	    if(isSuccess){
	    	result.setStatus("SUCCESS");
	    	result.setMessage("Agent Notified of Job Error");
	    }else{
	    	result.setStatus("FAILED");
	    	result.setMessage("Unable to perform the action");
	    }
	    return result;
	}

	@POST
	@Path("/jobStatusMessage")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RestMethodResult jobStatusMessage(final AgentJobReqParam param) {
	    log.debug("jobStatusMessage : {}", param);
	    
	    AgentJobMessageParam agentJobMessageParam = new AgentJobMessageParam();
	    agentJobMessageParam.setError(false);
	    agentJobMessageParam.setJobTicket(param.getJobTicket());
	    agentJobMessageParam.setMessage(param.getMessage());
	    agentJobMessageParam.setReferenceCode(param.getReferenceCode());
	    agentJobMessageParam.setServerAgent(new ServerAgent(param.getAgentId(), ""));
	    agentJobMessageParam.setState("UPDATE");
	    boolean isSuccess = agentJobService.agentJobMessageReceived(agentJobMessageParam);
	    
	    RestMethodResult result = new RestMethodResult();
	    result.setSuccess(isSuccess);
	    if(isSuccess){
	    	result.setStatus("SUCCESS");
	    	result.setMessage("Agent Notified of the message: " + param.getMessage());
	    }else{
	    	result.setStatus("FAILED");
	    	result.setMessage("Unable to perform the action");
	    }
	    return result;
	}
	
	@POST
	@Path("/agentFinishedGettingData")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RestMethodResult updateAgentFinishedGettingData(final AgentJobReqParam param) {
	    log.debug("updateAgentFinishedGettingData : {}", param);

	    AgentJobNotificationParam notificationParam = new AgentJobNotificationParam();
	    notificationParam.processRestRequestParam(param);
	    boolean isSuccess = agentJobService.markAgentJobAsFinishGettingDataNotificationReceived(notificationParam);
	    
	    RestMethodResult result = new RestMethodResult();
	    result.setSuccess(isSuccess);
	    if(isSuccess){
	    	result.setStatus("SUCCESS");
	    	result.setMessage("Agent Notified");
	    }else{
	    	result.setStatus("FAILED");
	    	result.setMessage("Unable to perform the action");
	    }
	    return result;
	}


	@POST
	@Path("/agentJobOnQueue")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RestMethodResult updateAgentJobOnQueue(final AgentJobReqParam param) {
	    log.debug("updateAgentJobOnQueue : {}", param);

	    AgentJobNotificationParam notificationParam = new AgentJobNotificationParam();
	    notificationParam.processRestRequestParam(param);
	    boolean isSuccess = agentJobService.markAgentJobAsJobOnQueueNotificationReceived(notificationParam);
	    
	    RestMethodResult result = new RestMethodResult();
	    result.setSuccess(isSuccess);
	    if(isSuccess){
	    	result.setStatus("SUCCESS");
	    	result.setMessage("Agent Notified");
	    }else{
	    	result.setStatus("FAILED");
	    	result.setMessage("Unable to perform the action");
	    }
	    return result;
	}


	@POST
	@Path("/agentJobStarted")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RestMethodResult updateAgentJobStarted(final AgentJobReqParam param) {
	    log.debug("updateAgentJobStarted : {}", param);

	    AgentJobNotificationParam notificationParam = new AgentJobNotificationParam();
	    notificationParam.processRestRequestParam(param);
	    boolean isSuccess = agentJobService.markAgentJobAsJobStartedNotificationReceived(notificationParam);
	    
	    RestMethodResult result = new RestMethodResult();
	    result.setSuccess(isSuccess);
	    if(isSuccess){
	    	result.setStatus("SUCCESS");
	    	result.setMessage("Agent Notified");
	    }else{
	    	result.setStatus("FAILED");
	    	result.setMessage("Unable to perform the action");
	    }
	    return result;
	}


	@POST
	@Path("/agentJobFinished")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RestMethodResult updateAgentJobFinished(final AgentJobReqParam param) {
	    log.debug("updateAgentJobFinished : {}", param);

	    AgentJobNotificationParam notificationParam = new AgentJobNotificationParam();
	    notificationParam.processRestRequestParam(param);
	    boolean isSuccess = agentJobService.markAgentJobAsJobFinishNotificationReceived(notificationParam);
	    
	    RestMethodResult result = new RestMethodResult();
	    result.setSuccess(isSuccess);
	    if(isSuccess){
	    	result.setStatus("SUCCESS");
	    	result.setMessage("Agent Notified");
	    }else{
	    	result.setStatus("FAILED");
	    	result.setMessage("Unable to perform the action");
	    }
	    return result;
	}


	@POST
	@Path("/agentJobSuccessful")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RestMethodResult updateAgentJobSuccessful(final AgentJobReqParam param) {
	    log.debug("updateAgentJobSuccessful : {}", param);
	    AgentJobNotificationParam notificationParam = new AgentJobNotificationParam();
	    notificationParam.processRestRequestParam(param);
	    boolean isSuccess = agentJobService.markAgentJobAsJobSuccessfulNotificationReceived(notificationParam);
	    
	    RestMethodResult result = new RestMethodResult();
	    result.setSuccess(isSuccess);
	    if(isSuccess){
	    	result.setStatus("SUCCESS");
	    	result.setMessage("Agent Notified");
	    }else{
	    	result.setStatus("FAILED");
	    	result.setMessage("Unable to perform the action");
	    }
	    return result;
	}


	@POST
	@Path("/agentJobFulfilled")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RestMethodResult updateAgentJobFulfilled(final AgentJobReqParam param) {
	    log.debug("updateAgentJobFulfilled : {}", param);

	    AgentJobNotificationParam notificationParam = new AgentJobNotificationParam();
	    notificationParam.processRestRequestParam(param);
	    boolean isSuccess = agentJobService.markAgentJobAsFulfillmentNotificationReceived(notificationParam);
	    
	    RestMethodResult result = new RestMethodResult();
	    result.setSuccess(isSuccess);
	    if(isSuccess){
	    	result.setStatus("SUCCESS");
	    	result.setMessage("Agent Notified");
	    }else{
	    	result.setStatus("FAILED");
	    	result.setMessage("Unable to perform the action");
	    }
	    return result;
	}


	@POST
	@Path("/agentJobPerformArchive")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RestMethodResult updateAgentJobPerformArchive(final AgentJobReqParam param) {
	    log.debug("updateAgentJobPerformArchive : {}", param);

	    AgentJobNotificationParam notificationParam = new AgentJobNotificationParam();
	    notificationParam.processRestRequestParam(param);
	    boolean isSuccess = true;
	    
	    RestMethodResult result = new RestMethodResult();
	    result.setSuccess(isSuccess);
	    if(isSuccess){
	    	result.setStatus("SUCCESS");
	    	result.setMessage("Agent Notified");
	    }else{
	    	result.setStatus("FAILED");
	    	result.setMessage("Unable to perform the action");
	    }
	    return result;
	}

	@POST
	@Path("/pullJobDefinition")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public AgentJobQueueParam pullJobDefinition(final AgentJobReqParam param) {
	    log.debug("pullJobDefinition : {}", param);

	    AgentJobNotificationParam notificationParam = new AgentJobNotificationParam();
	    notificationParam.processRestRequestParam(param);
	    AgentJobQueueParam agentJob = agentJobService.pullNewAgentJobQueue(notificationParam);
	    
	    return agentJob;
	}
	
*/}
