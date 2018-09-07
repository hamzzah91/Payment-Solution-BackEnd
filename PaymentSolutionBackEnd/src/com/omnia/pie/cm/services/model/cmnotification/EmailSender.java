package com.omnia.pie.cm.services.model.cmnotification;

public class EmailSender implements java.io.Serializable {

	private static final long serialVersionUID = 8581519132088783394L;
	// Fields

	private String name;
	private String emailAddress;
	private String category;
	private String status;
	private String incomingServer;
	private String incomingServerPort;
	private String outgoingServer;
	private String outgoingServerPort;
	private String username;
	private String password;
	// Constructors

	/** default constructor */
	public EmailSender() {
	}

	/** full constructor */
	public EmailSender(String name, String emailAddress, String category, String status, String incomingServer,
			String incomingServerPort, String outgoingServer, String outgoingServerPort, String username,
			String password) {
		this.name = name;
		this.emailAddress = emailAddress;
		this.category = category;
		this.status = status;
		this.incomingServer = incomingServer;
		this.incomingServerPort = incomingServerPort;
		this.outgoingServer = outgoingServer;
		this.outgoingServerPort = outgoingServerPort;
		this.username = username;
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getIncomingServer() {
		return this.incomingServer;
	}

	public void setIncomingServer(String incomingServer) {
		this.incomingServer = incomingServer;
	}

	public String getIncomingServerPort() {
		return this.incomingServerPort;
	}

	public void setIncomingServerPort(String incomingServerPort) {
		this.incomingServerPort = incomingServerPort;
	}

	public String getOutgoingServer() {
		return this.outgoingServer;
	}

	public void setOutgoingServer(String outgoingServer) {
		this.outgoingServer = outgoingServer;
	}

	public String getOutgoingServerPort() {
		return this.outgoingServerPort;
	}

	public void setOutgoingServerPort(String outgoingServerPort) {
		this.outgoingServerPort = outgoingServerPort;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}