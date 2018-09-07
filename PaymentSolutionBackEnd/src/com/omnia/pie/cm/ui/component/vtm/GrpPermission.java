package com.omnia.pie.cm.ui.component.vtm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.omnia.pie.cm.services.PermissionService;
import com.omnia.pie.cm.ui.component.BaseManageBean;
import com.omnia.pie.cm.ui.model.vtm.GrpPermissionUI;
import com.omnia.pie.cm.ui.model.vtm.UserGroupUI;
import com.omnia.pie.cm.ui.util.SpringScopeView;

@Component(value="grpPermission")
@SpringScopeView
public class GrpPermission extends BaseManageBean implements Serializable {

	private static final long serialVersionUID = 5238841005944005996L;
	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	private PermissionService permissionService;
	
	private List<GrpPermissionUI> permissionList;
	private List<GrpPermissionUI> allowedPermissionList;
	private List<UserGroupUI> customerGroup;
	private UserGroupUI selectedUserGroup;
	private String selectedUserGroupName;
	
	@PostConstruct
	public void init(){
		permissionList = new ArrayList<GrpPermissionUI>(0); 
		customerGroup = permissionService.listVtmCustomerUserGroup();
	}
	

	public List<GrpPermissionUI> getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(List<GrpPermissionUI> permissionList) {
		this.permissionList = permissionList;
	}

	public List<UserGroupUI> getCustomerGroup() {
		return customerGroup;
	}

	public void setCustomerGroup(List<UserGroupUI> customerGroup) {
		this.customerGroup = customerGroup;
	}

	public UserGroupUI getSelectedUserGroup() {
		log.debug("service selected user group.. {}", selectedUserGroup);
		return selectedUserGroup;
	}

	public void setSelectedUserGroup(UserGroupUI selectedUserGroup) {
		this.selectedUserGroup = selectedUserGroup;
		//log.debug("selected: {}", selectedUserGroup.getName());
	}
	
	public String getSelectedUserGroupName() {
		return selectedUserGroupName;
	}


	public void setSelectedUserGroupName(String selectedUserGroupName) {
		this.selectedUserGroupName = selectedUserGroupName;
	}
	
	public void onSelect(){
		if (selectedUserGroup == null)
			return;
		
		log.debug("selected: {}", selectedUserGroup.getName());
		permissionList = permissionService.listGroupPermission();
		allowedPermissionList = permissionService.listAllowedGroupPermission(selectedUserGroup);
		if (allowedPermissionList != null && !allowedPermissionList.isEmpty()){
			permissionList.forEach(v -> {
				allowedPermissionList.forEach(n -> {
					if (v.getId() == n.getId()) v.setAllowed(true);
				});
			});
		}
	}
	
	public void saveNewGroup(){
		log.debug("Request to save new User Group: {}", selectedUserGroupName);
		if (selectedUserGroupName == null || selectedUserGroupName == ""){
			log.error("Unable to save new user group {}", selectedUserGroupName);
			sendErrorNotification("Cannot save empty group name");
			return;
		}
		
		boolean result = permissionService.saveNewVTMUserGroup(selectedUserGroupName);
		
		if (result){
			customerGroup = permissionService.listVtmCustomerUserGroup();
			
			log.debug("New User Group saved.");
			sendNotification(selectedUserGroupName +  " saved!");
			
			selectedUserGroupName = null;
		}else{
			log.error("Failed to save new user group {}", selectedUserGroupName);
			sendErrorNotification("Failed to save: " + selectedUserGroup.getName());
		}
	}

	public void updateGroup(){
		if (selectedUserGroup != null && selectedUserGroup.getName() != null && selectedUserGroup.getName() != "" ){
			
			
			boolean result = permissionService.updateVTMUserGroup(selectedUserGroup);
			if (result){
				log.info("Group name successfuly updated: {}", selectedUserGroup.getName());
				sendNotification(selectedUserGroup.getName() +  " updated!");
			}else{
				log.error("Unable to perform update for the user group {}", selectedUserGroup.getName());
				sendErrorNotification("Failed to save: " + selectedUserGroup.getName());
			}
		}else{
			log.error("Unable to perform update, user group null.");
			sendErrorNotification("Cannot save empty group name");
		}
		
	}
	
	public void savePermissions(){
		if (selectedUserGroup == null)
			return;
		
		if (permissionList != null){
			log.debug("Listing allowed permission for {}", selectedUserGroup.getName());

			List<GrpPermissionUI> updatedPermissionList = new ArrayList<GrpPermissionUI>();
			permissionList.forEach(v -> {
				if (v.isAllowed()){
					log.debug("{}", v.getPermission());
					updatedPermissionList.add(v);
				}
			});
			
			boolean result = permissionService.updateGroupPermission(selectedUserGroup, updatedPermissionList);
			log.info("Updating Group Permission success result? {}", result);
		}
	}

}
