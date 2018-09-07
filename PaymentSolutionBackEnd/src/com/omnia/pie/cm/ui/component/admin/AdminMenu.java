package com.omnia.pie.cm.ui.component.admin;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 * 
 * @author M Louie
 * 
 */

@ManagedBean(name="adminMenu")
public class AdminMenu implements Serializable {

	private static final long serialVersionUID = 528294120937056825L;

	public void vtm() throws IOException{
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(".." + ec.getApplicationContextPath() + "/pages/admin/vtmdashboard.xhtml");
	}
}
