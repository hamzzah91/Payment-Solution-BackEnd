package com.omnia.pie.cm.ui.component.vtm;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.omnia.pie.cm.ui.model.vtm.TerminalInformation;
import com.omnia.pie.cm.ui.util.SpringScopeView;
import com.omnia.pie.cm.services.TerminalService;

@Component(value="terminalVtm")
@SpringScopeView
public class TerminalVtm implements Serializable {
	
	private static final long serialVersionUID = -4400248146222945251L;
	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

	private TerminalInformation terminalInfo;
	private String terminalId;
	private HashMap<String, String> deviceStatuses = new HashMap<String, String>();
	
	@Autowired
	private TerminalService terminalService;
	
	@PostConstruct
	public void init(){

		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String tId = request.getParameter("terminalId");
		if (tId != null)
			terminalId = tId;
		log.debug("Paramter from menu: {}", terminalId);
		
	}
	
	public void setTerminalInfo(TerminalInformation terminalInfo) {
		this.terminalInfo = terminalInfo;
	}

	public String getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}
	
	public HashMap<String, String> getDeviceStatuses() {
		return deviceStatuses;
	}

	public void setDeviceStatuses(HashMap<String, String> deviceStatuses) {
		this.deviceStatuses = deviceStatuses;
	}

}
