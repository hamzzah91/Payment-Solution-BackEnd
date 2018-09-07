package com.omnia.pie.cm.data.access;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.omnia.pie.base.dao.BaseDAOImpl;
import org.springframework.transaction.annotation.Transactional;

import com.omnia.pie.cm.data.model.UserPermissionDirectory;

/**
 * @see com.omnia.pie.cm.data.model.UserPermissionDirectory
 * @author M Louie
 */

@Transactional
public class UserPermissionDirectoryDAOImpl extends BaseDAOImpl<UserPermissionDirectory>
		implements UserPermissionDirectoryDAO {

	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

	public UserPermissionDirectoryDAOImpl() {

		super(UserPermissionDirectory.class);
	}

}