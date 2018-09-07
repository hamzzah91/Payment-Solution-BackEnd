package com.omnia.pie.cm.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sms_otp")
public class SmsOtp extends com.omnia.pie.base.model.Entity implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5902710894530504754L;
	private int		validated;
	private int 	mismatchCount;
	private String 	otp;
	private UserInfo userId;
	private String	sessionId;
	private String 	customData;
	private String 	uuid;
	private String smsStatus;
	private String smsSid;
	private String responseCode;
	
	@Column(name = "response_code")
	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	@Column(name = "sms_status")
	public String getSmsStatus() {
		return smsStatus;
	}

	public void setSmsStatus(String smsStatus) {
		this.smsStatus = smsStatus;
	}
	@Column(name = "sms_sid")
	public String getSmsSid() {
		return smsSid;
	}

	public void setSmsSid(String smsSid) {
		this.smsSid = smsSid;
	}

	public SmsOtp()
	{
		
	}
	
	@Column(name = "validated")
	public int getValidated() {
		return validated;
	}

	@Column(name = "otp")
	public String getOtp() {
		return otp;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false)
	public UserInfo getUserId() {
		return userId;
	}

	@Column(name = "session_id")
	public String getSessionId() {
		return sessionId;
	}

	@Column(name = "custom_data")
	public String getCustomData() {
		return customData;
	}
	
	@Column(name = "uuid")
	public String getUuid() {
		return uuid;
	}

	public void setValidated(int validated) {
		this.validated = validated;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public void setUserId(UserInfo userId) {
		this.userId = userId;
	}

	public void setSessionId(String session_id) {
		this.sessionId = session_id;
	}

	public void setCustomData(String custom_data) {
		this.customData = custom_data;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@Override
	public String toString() {
		return "SmsOtp [validated=" + validated + ", mismatch_count=" + mismatchCount + ", otp=" + otp
				+ ", customer_id=" + userId + ", session_id=" + sessionId + ", custom_data=" + customData
				+ ", uuid=" + uuid + "]";
	}
	
	public SmsOtp(int validated, int mismatch_count, String otp, UserInfo userId, String session_id,
			String custom_data, String uuid) {
		super();
		this.validated = validated;
		this.mismatchCount = mismatch_count;
		this.otp = otp;
		this.userId = userId;
		this.sessionId = session_id;
		this.customData = custom_data;
		this.uuid = uuid;
	}

	

	@Column(name = "mismatch_count")
	public int getMismatchCount() {
		return mismatchCount;
	}

	public void setMismatchCount(int mismatch_count) {
		this.mismatchCount = mismatch_count;
	}

}
