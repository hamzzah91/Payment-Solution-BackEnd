package com.omnia.pie.cm.data.access;

import java.util.List;

import com.omnia.pie.base.dao.BaseDAO;
import com.omnia.pie.cm.data.model.UserGroup;
import com.omnia.pie.cm.data.model.UserGroupPermissionType;

/**
 * @see com.omnia.pie.cm.data.model.UserGroupPermissionType
 * @author M Louie
 */

public interface UserGroupPermissionTypeDAO extends BaseDAO<UserGroupPermissionType> {

	List<UserGroupPermissionType> searchPermissionByGroup(UserGroup userGroup);
}