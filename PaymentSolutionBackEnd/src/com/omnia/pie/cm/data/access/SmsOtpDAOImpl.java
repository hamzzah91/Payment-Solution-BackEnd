package com.omnia.pie.cm.data.access;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.omnia.pie.base.dao.BaseDAOImpl;
import com.omnia.pie.cm.data.model.SmsOtp;
import com.omnia.pie.cm.data.model.TerminalInfo;
/**
 * @see com.omnia.pie.cm.data.model.SmsOtp
 * @author hamza
 */

@Transactional
public class SmsOtpDAOImpl extends BaseDAOImpl<SmsOtp> implements SmsOtpDAO {

	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

	public SmsOtpDAOImpl() {

		super(SmsOtp.class);
	}

	@Override
	public SmsOtp findSmsOtpByUUID(String UUID) {
		
		SmsOtp smsOtp = null;
		try {
			
			final StringBuilder hql = new StringBuilder();
			hql.append(" from SmsOtp e");
			hql.append(" where e.uuid = :uuid ");
			hql.append(" order by e.id desc ");
			
			log.debug("Executing Query: [{}] with parameters [{}, {}]", hql.toString(), UUID);
			
			Query query = getEntityManager().createQuery(hql.toString());
			query.setParameter("uuid", UUID);
			smsOtp = (SmsOtp) query.getSingleResult();
			
		} catch (Exception e) {
			
			smsOtp = null;
			log.debug("Exception occurred during query findSmsOtpByUUID({}, {})", UUID);
			log.debug("Exception: {}", e.getMessage());
		}
		
		return smsOtp;
	}

}