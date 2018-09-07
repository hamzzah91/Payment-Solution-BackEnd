package com.omnia.pie.cm.data.access;

import java.util.List;

import com.omnia.pie.base.dao.BaseDAO;
import com.omnia.pie.cm.data.model.UserGroup;
import com.omnia.pie.cm.data.model.UserGroupPermissionDirectory;
import com.omnia.pie.cm.data.model.UserGroupPermissionType;

/**
 * @see com.omnia.pie.cm.data.model.UserGroupPermissionDirectory
 * @author M Louie
 */

public interface UserGroupPermissionDirectoryDAO extends BaseDAO<UserGroupPermissionDirectory> {

	List<UserGroupPermissionDirectory> searchPermissionDirectoryByGroup(UserGroup userGroup);
	boolean removePermissionFromGroup(UserGroup userGroup, List<UserGroupPermissionType> permissionTypeList);
	boolean addPermissionFromGroup(UserGroup userGroup, List<UserGroupPermissionType> permissionTypeList);
}