package com.omnia.pie.cm.web.rest;

import java.util.Collections;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.omnia.pie.cm.web.rest.param.RulesRequest;
import com.omnia.pie.cm.web.rest.param.RulesResponse;

public class RulesServiceWebClient {

	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	public RulesResponse deviceStatusRule(final String baseUrl, final String endpoint, final RulesRequest rulesRequest){
		RulesResponse rulesResp = null;
		
		try {
			log.debug("Inquiring device rules from url: {} and endpoint: {}", baseUrl, endpoint);
			WebClient client = WebClient.create(baseUrl, Collections.singletonList(new JacksonJsonProvider()));
			client.path(endpoint).accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON);
			Response response = client.post(rulesRequest);
			rulesResp = response.readEntity(RulesResponse.class);
			log.info("Device rule enquriry Done! Notification Type: {}", rulesResp.getNotification());
		} catch (Exception e) {
			log.error("Error!", e);
		}
		
		return rulesResp;
	}

}
