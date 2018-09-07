package com.omnia.pie.cm.data.access;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.omnia.pie.base.dao.BaseDAOImpl;
import org.springframework.transaction.annotation.Transactional;

import com.omnia.pie.cm.data.model.Usalt;

/**
 * @see com.omnia.pie.cm.data.model.Usalt
 * @author M Louie
 */

@Transactional
public class UsaltDAOImpl extends BaseDAOImpl<Usalt> implements UsaltDAO {

	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

	public UsaltDAOImpl() {

		super(Usalt.class);
	}

}