package com.omnia.pie.cm.services.model.cmnotification;

public class EmailTemplate  implements java.io.Serializable {

	private static final long serialVersionUID = 8581519132088783394L;
    // Fields    

     private String name;
     private String subject;
     private String category;
     private String body;

    // Constructors

    /** default constructor */
    public EmailTemplate() {
    }
    
    /** full constructor */
    public EmailTemplate(String name, String subject, String category, String body) {
        this.name = name;
        this.subject = subject;
        this.category = category;
        this.body = body;
    }


    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return this.subject;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    public String getCategory() {
        return this.category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    public String getBody() {
        return this.body;
    }
    
    public void setBody(String body) {
        this.body = body;
    }

}