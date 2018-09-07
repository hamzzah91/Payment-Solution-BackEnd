package com.omnia.pie.cm.services;

import java.util.List;

import com.omnia.pie.cm.ui.model.vtm.GrpPermissionUI;
import com.omnia.pie.cm.ui.model.vtm.UserGroupUI;

public interface PermissionService {

	List<GrpPermissionUI> listGroupPermission();
	List<UserGroupUI> listVtmCustomerUserGroup();
	List<GrpPermissionUI> listAllowedGroupPermission(final UserGroupUI userGroupUI);
	boolean saveNewVTMUserGroup(String groupName);
	boolean updateVTMUserGroup(UserGroupUI userGroupUI);
	boolean updateGroupPermission(UserGroupUI userGroupUI, List<GrpPermissionUI> permissionList);
}
