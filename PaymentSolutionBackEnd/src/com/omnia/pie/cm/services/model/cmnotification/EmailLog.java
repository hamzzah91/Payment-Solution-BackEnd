package com.omnia.pie.cm.services.model.cmnotification;


public class EmailLog  implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8581519132088783394L;
	// Fields


	private EmailTemplate emailTemplate;
	private EmailTypes emailType;
	private String emailSender;
	private String emailRecipient;
	private String time;
	private String status;
	private String sessionId;
	private String emailContent;


	// Constructors

	/** default constructor */
	public EmailLog() {
	}

	/** full constructor */
	public EmailLog(EmailTemplate emailTemplate, EmailTypes emailType,
			String emailSender, String emailRecipient,
			String time, String status, String sessionId) {
		this.emailTemplate = emailTemplate;
		this.emailType = emailType;
		this.emailSender = emailSender;
		this.emailRecipient = emailRecipient;
		this.time = time;
		this.status = status;
		this.sessionId = sessionId;

	}


	public EmailTemplate getEmailTemplate() {
		return this.emailTemplate;
	}

	public void setEmailTemplate(EmailTemplate emailTemplate) {
		this.emailTemplate = emailTemplate;
	}

	public EmailTypes getEmailType() {
		return this.emailType;
	}

	public void setEmailType(EmailTypes emailType) {
		this.emailType = emailType;
	}

	public String getEmailSender() {
		return this.emailSender;
	}

	public void setEmailSender(String emailSender) {
		this.emailSender = emailSender;
	}

	public String getEmailRecipient() {
		return this.emailRecipient;
	}

	public void setEmailRecipient(String emailRecipient) {
		this.emailRecipient = emailRecipient;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSessionId() {
		return this.sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getEmailContent() {
		return emailContent;
	}

	public void setEmailContent(String emailContent) {
		this.emailContent = emailContent;
	}

}