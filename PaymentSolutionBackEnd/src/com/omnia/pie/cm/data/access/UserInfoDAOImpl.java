package com.omnia.pie.cm.data.access;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.omnia.pie.base.dao.BaseDAOImpl;
import com.omnia.pie.cm.data.model.UserInfo;

/**
 * @see com.omnia.pie.cm.data.model.UserInfo
 * @author hamza
 */

@Transactional
public class UserInfoDAOImpl extends BaseDAOImpl<UserInfo> implements UserInfoDAO {

	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

	public UserInfoDAOImpl() {

		super(UserInfo.class);
	}

}