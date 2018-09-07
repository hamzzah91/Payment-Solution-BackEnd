package com.omnia.pie.cm.web.rest;

import java.util.Collections;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.omnia.pie.cm.web.rest.param.EmailNotificationRequest;
import com.omnia.pie.cm.web.rest.param.EmailNotificationResponse;

public class NotificationServiceWebClient {

	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	public EmailNotificationResponse sendEmail(final String baseUrl, final String endpoint, final EmailNotificationRequest emailRequest){
		EmailNotificationResponse emailResp = null;
		
		try {
			log.debug("Sending email!");
			WebClient client = WebClient.create(baseUrl, Collections.singletonList(new JacksonJsonProvider()));
			client.path(endpoint).accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON);
			Response response = client.post(emailRequest);
			emailResp = response.readEntity(EmailNotificationResponse.class);
			log.info("Email sent! Status: {}", emailResp.getStatus());
		} catch (Exception e) {
			log.error("Error!", e);
		}
		
		return emailResp;
	}
}
