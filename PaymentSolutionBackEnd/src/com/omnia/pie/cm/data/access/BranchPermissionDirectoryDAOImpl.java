package com.omnia.pie.cm.data.access;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.omnia.pie.base.dao.BaseDAOImpl;
import org.springframework.transaction.annotation.Transactional;

import com.omnia.pie.cm.data.model.BranchPermissionDirectory;

/**
 * @see com.omnia.pie.cm.data.model.BranchPermissionDirectory
 * @author M Louie
 */

@Transactional
public class BranchPermissionDirectoryDAOImpl extends BaseDAOImpl<BranchPermissionDirectory>
		implements BranchPermissionDirectoryDAO {

	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

	public BranchPermissionDirectoryDAOImpl() {

		super(BranchPermissionDirectory.class);
	}

}