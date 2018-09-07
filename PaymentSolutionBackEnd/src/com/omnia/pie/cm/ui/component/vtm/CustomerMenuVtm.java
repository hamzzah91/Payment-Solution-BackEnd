package com.omnia.pie.cm.ui.component.vtm;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.omnia.pie.cm.services.TerminalService;
import com.omnia.pie.cm.ui.controller.CurrentUser;
import com.omnia.pie.cm.ui.util.SpringScopeSession;

/**
 * 
 * @author M Louie
 * 
 */

@Component(value="customerMenuVtm")
@SpringScopeSession
public class CustomerMenuVtm {

	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	
	@Autowired
	private TerminalService terminalService;
	
	@Autowired
	private CurrentUser currentUser;

	
	private List<String> terminals;

	public List<String> getTerminals() {
		//log.debug("getting terminals list: {}", terminals.size());
		return terminals;
	}

	@PostConstruct
	public void setupDataSources(){
		log.debug("populating terminal list for the menu");
		terminals = terminalService.listTerminalNamesByChannelCustomer(currentUser.getUserChannel(), currentUser.getUserCustomer());
	}
	
	public void setTerminals(List<String> terminals) {
		this.terminals = terminals;
	}

}
