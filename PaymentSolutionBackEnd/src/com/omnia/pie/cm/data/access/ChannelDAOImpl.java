package com.omnia.pie.cm.data.access;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.omnia.pie.base.dao.BaseDAOImpl;
import org.springframework.transaction.annotation.Transactional;

import com.omnia.pie.cm.data.model.Channel;

/**
 * @see com.omnia.pie.cm.data.model.Channel
 * @author M Louie
 */

@Transactional
public class ChannelDAOImpl extends BaseDAOImpl<Channel> implements ChannelDAO {

	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

	public ChannelDAOImpl() {
		super(Channel.class);
	}


	
}