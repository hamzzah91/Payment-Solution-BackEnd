package com.omnia.pie.cm.web.rest;

import java.util.Collections;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.omnia.pie.cm.models.snapshot.terminal.v2.DeviceStatusObject;
import com.omnia.pie.cm.web.CustomObjectMapper;
import com.omnia.pie.cm.web.rest.param.DeviceStatusRequest;

public class DeviceStatusServiceWebClient {

	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	public DeviceStatusObject findDeviceStatus(final String baseUrl, final String endpoint, final DeviceStatusRequest statusRequest){
		DeviceStatusObject statusResponse = null;
		
		try {
			JacksonJsonProvider jsonProvider = new JacksonJsonProvider();
			jsonProvider.setMapper(new CustomObjectMapper());
			WebClient client = WebClient.create(baseUrl, Collections.singletonList(jsonProvider));
			client.path(endpoint).accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON);
			Response response = client.post(statusRequest);
			statusResponse = response.readEntity(DeviceStatusObject.class);
		} catch (Exception e) {
			log.error("Error!", e);
		}
		
		return statusResponse;
	}
}
