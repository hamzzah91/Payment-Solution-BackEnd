package com.omnia.pie.cm.ui.component.vtm;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.omnia.pie.cm.services.PermissionService;
import com.omnia.pie.cm.services.UserService;
import com.omnia.pie.cm.ui.component.BaseManageBean;
import com.omnia.pie.cm.ui.model.vtm.UserGroupUI;
import com.omnia.pie.cm.ui.model.vtm.UsrManagementUI;
import com.omnia.pie.cm.ui.util.SpringScopeView;

@Component(value="usrManagement")
@SpringScopeView
public class UsrManagement extends BaseManageBean implements Serializable {
	
	private static final long serialVersionUID = -134211136403526345L;
	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	private UserService userService;
	@Autowired
	private PermissionService permissionService;
	
	private UsrManagementUI selectedUser;
	private UsrManagementUI newUser;
	private List<UsrManagementUI> userList;
	private List<UserGroupUI> customerGroup;
	
	@PostConstruct
	public void init(){
		userList = userService.listAllUsers();
		customerGroup = permissionService.listVtmCustomerUserGroup();
	}

	public UsrManagementUI getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(UsrManagementUI selectedUser) {
		this.selectedUser = selectedUser;
	}

	public List<UsrManagementUI> getUserList() {
		return userList;
	}

	public void setUserList(List<UsrManagementUI> userList) {
		this.userList = userList;
	}

	public UsrManagementUI getNewUser() {
		return newUser;
	}

	public void setNewUser(UsrManagementUI newUser) {
		this.newUser = newUser;
	}
	
	public void prepareNewUsr(){
		newUser = new UsrManagementUI();
		log.debug("Preparing new user..");
	}

	public List<UserGroupUI> getCustomerGroup() {
		return customerGroup;
	}

	public void setCustomerGroup(List<UserGroupUI> customerGroup) {
		this.customerGroup = customerGroup;
	}
	
	public void saveNewUsr(){
		log.debug("Saving new user.");
		log.debug("Username: {}", this.newUser.getUsername());
		log.debug("Email: {}", this.newUser.getEmail());
		log.debug("Group: {}", this.newUser.getUserGroupId());
	}
	
	public void updateUsr(){
		log.debug("Updating user.");
	}


}
