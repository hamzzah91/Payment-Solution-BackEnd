package com.omnia.pie.cm.data.access;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.omnia.pie.base.dao.BaseDAOImpl;
import org.springframework.transaction.annotation.Transactional;

import com.omnia.pie.cm.data.model.Users;

/**
 * @see com.omnia.pie.cm.data.model.Users
 * @author M Louie
 */

@Transactional
public class UsersDAOImpl extends BaseDAOImpl<Users> implements UsersDAO {

	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

	public UsersDAOImpl() {

		super(Users.class);
	}

}