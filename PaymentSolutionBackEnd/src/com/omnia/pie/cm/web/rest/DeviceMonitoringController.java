package com.omnia.pie.cm.web.rest;

import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.omnia.pie.cm.models.snapshot.terminal.v2.DeviceEventObject;
import com.omnia.pie.cm.models.snapshot.terminal.v2.DeviceStatusObject;
import com.omnia.pie.cm.web.rest.param.DeviceObjectResponse;
import com.omnia.pie.cm.web.rest.param.FileUploadData;
import com.omnia.pie.cm.web.rest.param.RestMethodResult;

@Path(value = "/")
public class DeviceMonitoringController {/*

	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	private VtmDeviceMonitoringService vtmDeviceMonitoringService;
	
	@POST
	@Path("/processDeviceStatus")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RestMethodResult processDeviceStatus(final DeviceStatusObject deviceStatus){
		RestMethodResult restResult = new RestMethodResult();
		log.debug("Processing device status.");
		DeviceObjectResponse resp = vtmDeviceMonitoringService.insertDeviceStatus(deviceStatus);
		restResult.setSuccess(true);
		restResult.setStatus("PROCESSING");
		restResult.setMessage("Processing device status");
		
		return restResult;
	}
	
	@POST
	@Path("/insertDeviceStatus")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public DeviceObjectResponse insertDeviceStatus(final DeviceStatusObject deviceStatus){
		log.debug("Inserting and processing device status.");
		DeviceObjectResponse restResult = null;
		restResult = vtmDeviceMonitoringService.insertDeviceStatus(deviceStatus);
		return restResult;
	}
	
	@POST
	@Path("/insertDeviceEvent")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public DeviceObjectResponse processDeviceEvent(final DeviceEventObject deviceEvent){
		log.debug("Inserting and processing device event.");
		DeviceObjectResponse restResult = null;
		restResult = vtmDeviceMonitoringService.insertDeviceEvent(deviceEvent);
		return restResult;
	}
	
	
	@POST
	@Path("/uploadFile/{type}/{terminalId}/{date}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public DeviceObjectResponse uploadFile(
			@PathParam("type") String type,  
			@PathParam("terminalId") String terminalId, 
			@PathParam("date") String date,
			@Multipart("file") Attachment attachement){
		
		String filename = attachement.getContentDisposition().getFilename();
		
		log.debug("Upload file with type: {} and filename: {} for terminal: {} and date {}.", type, filename, terminalId, date);
		
		FileUploadData fileData = new FileUploadData();
		fileData.setTerminal(terminalId);
		fileData.setType(type);
		fileData.setFileTimestamp(date);
		fileData.setFileInputStream(attachement.getObject(InputStream.class));
		fileData.setFilename(filename);
		
		DeviceObjectResponse restResult = null;
		restResult = vtmDeviceMonitoringService.saveUploadedFile(fileData);
		

		try {
			if (fileData.getFileInputStream() != null)
				fileData.getFileInputStream().close();
		} catch (IOException e) {
			log.error("Error closing attached file inputstream!");
		}
		
		return restResult;
	}
	
*/}
