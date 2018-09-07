package com.omnia.pie.cm.data.access;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.omnia.pie.base.dao.BaseDAOImpl;
import org.springframework.transaction.annotation.Transactional;

import com.omnia.pie.cm.data.model.UserPermissionType;

/**
 * @see com.omnia.pie.cm.data.model.UserPermissionType
 * @author M Louie
 */

@Transactional
public class UserPermissionTypeDAOImpl extends BaseDAOImpl<UserPermissionType> implements UserPermissionTypeDAO {

	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

	public UserPermissionTypeDAOImpl() {
		super(UserPermissionType.class);
	}

}