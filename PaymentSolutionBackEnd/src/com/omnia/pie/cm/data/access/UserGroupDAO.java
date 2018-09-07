package com.omnia.pie.cm.data.access;

import java.util.List;

import com.omnia.pie.base.dao.BaseDAO;
import com.omnia.pie.cm.data.model.UserGroup;

/**
 * @see com.omnia.pie.cm.data.model.UserGroup
 * @author M Louie
 */

public interface UserGroupDAO extends BaseDAO<UserGroup> {

	List<UserGroup> searchAllByGroupCode(String groupCode);
	List<UserGroup> searchByNameByGroupCode(String name, String groupCode);
}