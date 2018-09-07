package com.omnia.pie.cm.services.model.cmnotification;

public class EmailMapping extends com.omnia.pie.base.model.Entity implements java.io.Serializable {


	private static final long serialVersionUID = 6508833694918288881L;
    // Fields    

     private String emailTemplate;
     private String emailType;
     private String emailSender;
     private String emailRecipient;


    // Constructors

    /** default constructor */
    public EmailMapping() {
    }

    
    /** full constructor */
    public EmailMapping(String emailTemplate, String emailType, String emailSender, String emailRecipient) {
        this.emailTemplate = emailTemplate;
        this.emailType = emailType;
        this.emailSender = emailSender;
        this.emailRecipient = emailRecipient;

    }

   
    public String getEmailTemplate() {
        return this.emailTemplate;
    }
    
    public void setEmailTemplate(String emailTemplate) {
        this.emailTemplate = emailTemplate;
    }
    
    public String getEmailType() {
        return this.emailType;
    }
    
    public void setEmailType(String emailType) {
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
    

}