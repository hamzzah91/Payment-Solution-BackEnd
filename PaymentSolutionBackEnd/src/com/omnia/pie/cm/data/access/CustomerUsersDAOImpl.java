package com.omnia.pie.cm.data.access;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.omnia.pie.base.dao.BaseDAOImpl;
import org.springframework.transaction.annotation.Transactional;

import com.omnia.pie.cm.data.model.CustomerUsers;

/**
 * @see com.omnia.pie.cm.data.model.Customer
 * @author M Louie
 */

@Transactional
public class CustomerUsersDAOImpl extends BaseDAOImpl<CustomerUsers> implements CustomerUsersDAO {

	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

	public CustomerUsersDAOImpl() {

		super(CustomerUsers.class);
	}

}