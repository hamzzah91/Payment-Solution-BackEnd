package com.omnia.pie.cm.ui.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omnia.pie.cm.data.model.TerminalInfo;
import com.omnia.pie.cm.services.TerminalService;
import com.omnia.pie.cm.ui.model.vtm.ActionResult;

/**
 * @author M Louie
 *
 */

@Service ("ejLogController")
public class EjLogControllerImpl implements EjLogController {/*

	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());
	private DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
	
	@Autowired
	private TerminalService terminalService;

	@Autowired
	private CurrentUser currentUser;


	@Override
	public ActionResult updateEjSchedule(TerminalEJSettings terminalEJSettings) {
		
		boolean updateResult = terminalService.updateEjSchedule(currentUser.getUserChannel(), currentUser.getUserCustomer(), new TerminalInfo(terminalEJSettings.getTerminal()), terminalEJSettings.getSftpPath(), terminalEJSettings.getOccurence(),terminalEJSettings.getSftpPort(),terminalEJSettings.getSftpUser(),terminalEJSettings.getSftpPassword(), formatter.format(terminalEJSettings.getUploadSchedule()));
		
		ActionResult result = new ActionResult();
		result.setSuccess(updateResult);
		if (updateResult)
			result.setMessage("Update successful for the terminal " + terminalEJSettings.getTerminal());
		else
			result.setMessage("Error updating schedule for terminal " + terminalEJSettings.getTerminal());
		
		return result;
	}


	@Override
	public ActionResult updateLogSchedule(TerminalLogSettings terminalLogSettings) {
		
		boolean updateResult = terminalService.updateLogSchedule(currentUser.getUserChannel(), currentUser.getUserCustomer(), new TerminalInfo(terminalLogSettings.getTerminal()), terminalLogSettings.getSftpPath(), terminalLogSettings.getOccurence(),terminalLogSettings.getSftpPort(),terminalLogSettings.getSftpUser(),terminalLogSettings.getSftpPassword(), formatter.format(terminalLogSettings.getUploadSchedule()));
		
		ActionResult result = new ActionResult();
		result.setSuccess(updateResult);
		if (updateResult)
			result.setMessage("Update successful for the terminal " + terminalLogSettings.getTerminal());
		else
			result.setMessage("Error updating schedule for terminal " + terminalLogSettings.getTerminal());
		
		return result;
	}


	@Override
	public List<TerminalEJSettings> listTerminalEjSettings() {
		List<TerminalEJSettings> ejSettingsList = new ArrayList<TerminalEJSettings>();
		
		List<CustomerEjUploadSettings> listEj = terminalService.listEjSettingsByChannelCustomer(currentUser.getUserChannel(), currentUser.getUserCustomer(), false);
		
		ejSettingsList = new ArrayList<TerminalEJSettings>();
		TerminalEJSettings ej= null;
  		
		for (CustomerEjUploadSettings cEj : listEj){
			ej = new TerminalEJSettings();
			ej.setTerminal(cEj.getTerminalInfo().getTerminalId());
			ej.setSftpPath(cEj.getDestinationPath());
			ej.setOccurence(cEj.getOccurence());
			ej.setSftpUser(cEj.getDestinationUser());
			ej.setSftpPassword(cEj.getDestinationPassword());
			ej.setSftpPort(cEj.getDestinationPort());
			try {
				Date sched = formatter.parse(cEj.getScheduledTime());
				LocalDateTime localDateTime = LocalDateTime.ofInstant(sched.toInstant(), ZoneId.systemDefault());
				ej.setUploadSchedule(sched);
				ej.setHours(localDateTime.getHour());
				ej.setMinutes(localDateTime.getMinute());
				ej.setSeconds(localDateTime.getSecond());
			} catch (ParseException e1) {
				log.error("Error: ", e1.getMessage());
				e1.printStackTrace();
			}
			
			ejSettingsList.add(ej);
		}
		
		return ejSettingsList;
	}


	@Override
	public List<TerminalLogSettings> listTerminalLogSettings() {
		List<TerminalLogSettings> logSettingsList = new ArrayList<TerminalLogSettings>();
		
		List<CustomerLogUploadSettings> listEj = terminalService.listLogSettingsByChannelCustomer(currentUser.getUserChannel(), currentUser.getUserCustomer(), false);
		
		logSettingsList = new ArrayList<TerminalLogSettings>();
		TerminalLogSettings appLog= null;
  		
		for (CustomerLogUploadSettings cEj : listEj){
			appLog = new TerminalLogSettings();
			appLog.setTerminal(cEj.getTerminalInfo().getTerminalId());
			appLog.setSftpPath(cEj.getDestinationPath());
			appLog.setOccurence(cEj.getOccurence());
			appLog.setSftpUser(cEj.getDestinationUser());
			appLog.setSftpPassword(cEj.getDestinationPassword());
			appLog.setSftpPort(cEj.getDestinationPort());
			try {
				Date sched = formatter.parse(cEj.getScheduledTime());
				LocalDateTime localDateTime = LocalDateTime.ofInstant(sched.toInstant(), ZoneId.systemDefault());
				appLog.setUploadSchedule(sched);
				appLog.setHours(localDateTime.getHour());
				appLog.setMinutes(localDateTime.getMinute());
				appLog.setSeconds(localDateTime.getSecond());
			} catch (ParseException e1) {
				log.error("Error: ", e1.getMessage());
				e1.printStackTrace();
			}
			
			logSettingsList.add(appLog);
		}
		
		return logSettingsList;
	}	
	
	
*/}
