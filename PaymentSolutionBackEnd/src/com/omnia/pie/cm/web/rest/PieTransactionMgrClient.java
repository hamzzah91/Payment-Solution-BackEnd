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
import com.omnia.pie.cm.web.rest.param.TerminalRequestPieDb;

public class PieTransactionMgrClient {

	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	public Boolean addTerminalInPieDB(final String baseUrl, final String endpoint, final TerminalRequestPieDb terminalRequest){
		Boolean addTerminalResult = false;
		
		try {
			log.debug("Saving Terminal in Pie Transaction Manager DB");
			WebClient client = WebClient.create(baseUrl, Collections.singletonList(new JacksonJsonProvider()));
			client.path(endpoint).accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON);
			Response response = client.post(terminalRequest);
			addTerminalResult = response.readEntity(Boolean.class);
			log.info("Add Terminal! Status: {}", addTerminalResult);
		} catch (Exception e) {
			addTerminalResult = false;
			log.error("Error!", e);
		}
		
		return addTerminalResult;
	}
}
