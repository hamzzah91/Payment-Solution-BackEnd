package com.omnia.pie.cm.data.access;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.omnia.pie.base.dao.BaseDAOImpl;
import org.springframework.transaction.annotation.Transactional;

import com.omnia.pie.cm.data.model.CustomerPermissionType;

/**
 * @see com.omnia.pie.cm.data.model.CustomerPermissionType
 * @author M Louie
 */

@Transactional
public class CustomerPermissionTypeDAOImpl extends BaseDAOImpl<CustomerPermissionType>
		implements CustomerPermissionTypeDAO {

	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

	public CustomerPermissionTypeDAOImpl() {

		super(CustomerPermissionType.class);
	}

}