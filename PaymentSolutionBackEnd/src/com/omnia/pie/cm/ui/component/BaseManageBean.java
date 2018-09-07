package com.omnia.pie.cm.ui.component;

import java.time.ZoneId;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 
 * @author M Louie
 * 
 */

public class BaseManageBean {

	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	protected void sendNotification(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
	protected void sendErrorNotification(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
	public String timezone(){
		log.trace("Requested for timezone: {}", ZoneId.systemDefault().toString());
		return ZoneId.systemDefault().toString();
	}
}
