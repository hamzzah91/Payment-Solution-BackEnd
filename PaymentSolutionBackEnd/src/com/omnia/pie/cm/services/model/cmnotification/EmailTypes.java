package com.omnia.pie.cm.services.model.cmnotification;

public class EmailTypes implements java.io.Serializable {

	private static final long serialVersionUID = 8581519132088783394L;
	// Fields

	private String code;
	private String description;

	// Constructors

	/** default constructor */
	public EmailTypes() {
	}

	/** full constructor */
	public EmailTypes(String code, String description) {
		this.code = code;
		this.description = description;
	}


	public EmailTypes(String code) {
		this.code = code;
	}
	

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}