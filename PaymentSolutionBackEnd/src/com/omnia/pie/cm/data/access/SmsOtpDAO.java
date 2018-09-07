package com.omnia.pie.cm.data.access;

import com.omnia.pie.base.dao.BaseDAO;
import com.omnia.pie.cm.data.model.SmsOtp;

/**
 * @see com.omnia.pie.cm.data.model.SmsOtp
 * @author hamza
 */
public interface SmsOtpDAO extends BaseDAO<SmsOtp> {
	
	SmsOtp findSmsOtpByUUID(String UUID);
}