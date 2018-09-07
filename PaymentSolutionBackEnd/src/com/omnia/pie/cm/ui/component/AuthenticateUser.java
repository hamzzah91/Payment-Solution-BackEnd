package com.omnia.pie.cm.ui.component;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omnia.pie.cm.access.utils.LoggedUser;
import com.omnia.pie.cm.data.model.Users;
import com.omnia.pie.cm.services.UserService;
import com.omnia.pie.cm.ui.util.SpringScopeSession;

/**
 * 
 * @author M Louie
 * 
 */

@ManagedBean(name="authenticateUser")
@SpringScopeSession
@Service
public class AuthenticateUser extends BaseManageBean implements Serializable {

	private static final long serialVersionUID = -5583392445102607392L;

	private String username;
	private String password;
	private String userType;
	
	@Autowired
	private UserService userService;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	public String validate(){
		if (username == null){
			userType = "unknown";
			return userType;
		}
		boolean validationResult = userService.validateUserCredentials(username, password);
		if(validationResult)
		{
			Users user = userService.findUserByUserName(username);
			/*LoggedUser.init(user);
			System.err.println("after init :" + LoggedUser.hasUser());
			*/ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			ec.getSessionMap().put("loggedUser", user);
			if(username.startsWith("a")){
				userType = "admin";
			} else if(username.startsWith("m")){
				userType = "mpos";
			} else if(username.startsWith("v")){
				userType = "vtm";
			}else{
				userType = "unknown";
			}
		}
		else
		{
			userType = "unknown";
		}
		return userType;
	}
	
	public void logout() throws IOException{
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.getSessionMap().put("loggedFlag", "false");
		ec.getSessionMap().put("loggedUser", null);
		   HttpSession session = (HttpSession) ec.getSession(false);
		   System.err.println("logout :"+LoggedUser.hasUser()+" "+LoggedUser.user().getUsername());
		   LoggedUser.cleanup();
		   System.err.println("after cleanup :" + LoggedUser.hasUser());
		   // Destroys the session for this user.
		   if (session != null)
		        session.invalidate();
		ec.invalidateSession();
		//ec.redirect(".." + ec.getApplicationContextPath() + "/index.jsp");
		ec.redirect(ec.getApplicationContextPath());
	}
}
