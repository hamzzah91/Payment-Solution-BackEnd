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
import com.omnia.pie.cm.ui.model.vtm.TerminalRemoteDeploymentSettings;

/**
 * @author M Louie
 *
 */

@Service ("remoteDeploymentController")
public class TerminalRemoteDeploymentControllerImpl implements TerminalRemoteDeploymentController {

	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());
	private DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
	
	@Autowired
	private TerminalService terminalService;

	@Autowired
	private CurrentUser currentUser;

	@Override
	public List<TerminalRemoteDeploymentSettings> listRemoteDeploymentConfigs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TerminalRemoteDeploymentSettings getTerminalLastRecord(TerminalInfo t) {
		// TODO Auto-generated method stub
		return null;
	}


/*	@Override
	public ActionResult updateAntiSkimmingSchedule(TerminalAntiSkimmingSettings terminalAntiSkimmingSettings) {
		
		boolean updateResult = terminalService.updateAntiSkimmingSchedule(currentUser.getUserChannel(), currentUser.getUserCustomer(), new TerminalInfo(terminalAntiSkimmingSettings.getTerminal()), terminalAntiSkimmingSettings.getOccurence(), formatter.format(terminalAntiSkimmingSettings.getUploadSchedule()));
		
		ActionResult result = new ActionResult();
		result.setSuccess(updateResult);
		if (updateResult)
			result.setMessage("Update AntiSkimming successful for the terminal " + terminalAntiSkimmingSettings.getTerminal());
		else
			result.setMessage("Error updating AntiSkimming schedule for terminal " + terminalAntiSkimmingSettings.getTerminal());
		
		return result;
	}*/


}
