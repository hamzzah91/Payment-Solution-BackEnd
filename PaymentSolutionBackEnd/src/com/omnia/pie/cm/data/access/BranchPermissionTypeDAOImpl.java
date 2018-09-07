package com.omnia.pie.cm.data.access;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.omnia.pie.base.dao.BaseDAOImpl;
import org.springframework.transaction.annotation.Transactional;

import com.omnia.pie.cm.data.model.BranchPermissionType;

/**
 * @see com.omnia.pie.cm.data.model.BranchPermissionType
 * @author M Louie
 */

@Transactional
public class BranchPermissionTypeDAOImpl extends BaseDAOImpl<BranchPermissionType> implements BranchPermissionTypeDAO {

	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

	public BranchPermissionTypeDAOImpl() {

		super(BranchPermissionType.class);
	}

}