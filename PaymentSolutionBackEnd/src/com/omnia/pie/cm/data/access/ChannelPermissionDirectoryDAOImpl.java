package com.omnia.pie.cm.data.access;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.omnia.pie.base.dao.BaseDAOImpl;
import org.springframework.transaction.annotation.Transactional;

import com.omnia.pie.cm.data.model.ChannelPermissionDirectory;

/**
 * @see com.omnia.pie.cm.data.model.ChannelPermissionDirectory
 * @author M Louie
 */

@Transactional
public class ChannelPermissionDirectoryDAOImpl extends BaseDAOImpl<ChannelPermissionDirectory>
		implements ChannelPermissionDirectoryDAO {

	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

	public ChannelPermissionDirectoryDAOImpl() {

		super(ChannelPermissionDirectory.class);
	}

}