package com.omnia.pie.cm.data.access;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.omnia.pie.base.dao.BaseDAOImpl;
import org.springframework.transaction.annotation.Transactional;

import com.omnia.pie.cm.data.model.ChannelPermissionType;

/**
 * @see com.omnia.pie.cm.data.model.ChannelPermissionType
 * @author M Louie
 */

@Transactional
public class ChannelPermissionTypeDAOImpl extends BaseDAOImpl<ChannelPermissionType>
		implements ChannelPermissionTypeDAO {

	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

	public ChannelPermissionTypeDAOImpl() {

		super(ChannelPermissionType.class);
	}

}