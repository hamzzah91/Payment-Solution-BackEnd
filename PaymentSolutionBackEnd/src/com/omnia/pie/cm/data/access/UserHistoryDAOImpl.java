package com.omnia.pie.cm.data.access;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.omnia.pie.base.dao.BaseDAOImpl;
import org.springframework.transaction.annotation.Transactional;

import com.omnia.pie.cm.data.model.UserHistory;

/**
 * @see com.omnia.pie.cm.data.model.UserHistory
 * @author M Louie
 */

@Transactional
public class UserHistoryDAOImpl extends BaseDAOImpl<UserHistory> implements UserHistoryDAO {

	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

	public UserHistoryDAOImpl() {

		super(UserHistory.class);
	}

}