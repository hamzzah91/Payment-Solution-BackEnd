package com.omnia.pie.cm.web.rest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.ws.rs.core.Response;

import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.jaxrs.client.WebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.omnia.pie.cm.web.rest.param.LeadsFileRequest;

public class LeadsFileWebClient {
	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());
	public boolean fetchLeadsFileFromCMRepo(final String baseUrl, String endpoint, final LeadsFileRequest request){
		boolean FTPResult = false;	
		if(endpoint != null && !endpoint.isEmpty()
				&& request != null && request.getCustomerId()!= null && request.getTerminalId()!=null
				&& !request.getTerminalId().isEmpty() && !request.getCustomerId().isEmpty())
			{
				endpoint+="/"+request.getCustomerId()+"/"+request.getTerminalId();
			}
		else
		{
			log.debug("some required parameters are empty");
			return false;
		}
		try {
			WebClient client = WebClient.create(baseUrl);
			client.path(endpoint);
			Response response = client.get();
			////////////////////////////////
			//read the file name from header
			String disposition= response.getHeaderString("Content-Disposition");
			//System.err.println("disposition : "+disposition);
			String fileName = disposition.replaceFirst("(?i)^.*filename=\"?([^\"]+)\"?.*$", "$1");
			//String fileName = URLDecoder.decode(disposition, StandardCharsets.ISO_8859_1.toString());
			System.err.println("Leads file name : "+fileName);
			/////////////////////////////////
			InputStream is = (InputStream)response.getEntity();	
			// FTPResult =	writeFileToFTP(is,ftpURL,ftpPort,ftpUser,ftpPassword,fileName);
			//log.debug("FTP Result For File Saving:"+ FTPResult);
			// String text = IOUtils.toString(is, StandardCharsets.UTF_8.name());

			  if(is != null)
				 is.close();
			/*  
				  //saving the response to a local file
			  String FILENAME = "E:\\ChannelMgt\\test.txt";
			  BufferedWriter bw = null;
			  FileWriter fw = null;
			  fw = new FileWriter(FILENAME);
				bw = new BufferedWriter(fw);
				bw.write(text);
				
				
				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();*/
				
		} catch (Exception e) {
			log.error("Error!", e);
			FTPResult = false;
		}
		return FTPResult;
		
	}
}
