package com.omnia.pie.cm.data.access;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.omnia.pie.base.dao.BaseDAOImpl;
import org.springframework.transaction.annotation.Transactional;

import com.omnia.pie.cm.data.model.CustomerPermissionDirectory;

/**
 * @see com.omnia.pie.cm.data.model.CustomerPermissionDirectory
 * @author M Louie
 */

@Transactional
public class CustomerPermissionDirectoryDAOImpl extends BaseDAOImpl<CustomerPermissionDirectory>
		implements CustomerPermissionDirectoryDAO {

	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

	public CustomerPermissionDirectoryDAOImpl() {

		super(CustomerPermissionDirectory.class);
	}

}