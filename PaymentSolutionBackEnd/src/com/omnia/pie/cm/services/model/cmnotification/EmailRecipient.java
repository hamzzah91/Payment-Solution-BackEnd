package com.omnia.pie.cm.services.model.cmnotification;


public class EmailRecipient implements java.io.Serializable {

	private static final long serialVersionUID = 8581519132088783394L;

    // Fields    

     private String recipientId;
     private String firstName;
     private String lastName;
     private String emailAddress;
     private String category;
     private String status;


    // Constructors

    /** default constructor */
    public EmailRecipient() {
    }

    
    /** full constructor */
    public EmailRecipient(String recipientId, String firstName, String lastName, String emailAddress, String category, String status) {
        this.recipientId = recipientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.category = category;
        this.status = status;
    }

    
    public String getRecipientId() {
        return this.recipientId;
    }
    
    public void setRecipientId(String recipientId) {
        this.recipientId = recipientId;
    }
    
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getEmailAddress() {
        return this.emailAddress;
    }
    
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    
    public String getCategory() {
        return this.category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }


}