package com.omnia.pie.cm.ui.controller;

import java.util.List;

import com.omnia.pie.cm.data.model.TerminalInfo;
import com.omnia.pie.cm.ui.model.vtm.TerminalRemoteDeploymentSettings;

/**
 * @author Hamza
 *
 */

public interface TerminalRemoteDeploymentController {

	public List<TerminalRemoteDeploymentSettings> listRemoteDeploymentConfigs();
	//public ActionResult updateAntiSkimmingSchedule(TerminalAntiSkimmingSettings terminalAntiSkimmingSettings);
	public TerminalRemoteDeploymentSettings getTerminalLastRecord(TerminalInfo t); 

}
