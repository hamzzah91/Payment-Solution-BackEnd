package com.omnia.pie.cm.web.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.omnia.pie.cm.web.rest.param.RestMethodResult;
import com.omnia.pie.cm.services.model.AgentJobQueueParam;
import com.omnia.pie.cm.web.rest.param.AgentJobReqParam;


@Path(value = "/")
public class AgentJobController {/*
	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	private AgentJobService agentJobService;
	
    @POST
	@Path("/agentNotified")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RestMethodResult updateAgentNotified(final AgentJobReqParam param) {
	    log.debug("updateAgentNotified : {}", param);

	    AgentJobNotificationParam notificationParam = new AgentJobNotificationParam();
	    notificationParam.processRestRequestParam(param);
	    boolean isSuccess = agentJobService.markAgentJobAsAgentNotifiedNotificationReceived(notificationParam);
	    
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
