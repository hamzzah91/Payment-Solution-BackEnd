package com.omnia.pie.cm.web.rest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;

import javax.ws.rs.core.Response;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.cxf.jaxrs.client.WebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.omnia.pie.cm.web.rest.param.LogFileRequest;

public class LogFileWebClient {

	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

	public boolean fetchAndUploadLogFiles(final String baseUrl, String endpoint, String logFileType,
			final LogFileRequest request, String ftpURL, Integer ftpPort, String ftpUser, String ftpPassword) {
		log.debug("fetchAndUploadEJFiles");

		boolean FTPResult = false;
		if (endpoint != null && !endpoint.isEmpty() && request != null && request.getCustomerId() != null
				&& request.getTerminalId() != null && !request.getTerminalId().isEmpty()
				&& !request.getCustomerId().isEmpty() && ftpURL != null && !ftpURL.isEmpty() && ftpUser != null
				&& !ftpUser.isEmpty() && ftpPassword != null && !ftpPassword.isEmpty() && !logFileType.isEmpty()
				&& logFileType != null) {
			endpoint += "/" + request.getCustomerId() + "/" + request.getTerminalId() + "/" + logFileType;
		} else {
			log.debug("some required parameters are empty");
			return false;
		}
		try {
			WebClient client = WebClient.create(baseUrl);
			client.path(endpoint);
			Response response = client.get();
			////////////////////////////////
			// read the file name from header
			String disposition = response.getHeaderString("Content-Disposition");
			// System.err.println("disposition : "+disposition);
			String fileName = disposition.replaceFirst("(?i)^.*filename=\"?([^\"]+)\"?.*$", "$1");
			// String fileName = URLDecoder.decode(disposition,
			// StandardCharsets.ISO_8859_1.toString());
			// System.err.println("final file name : "+fileName);
			/////////////////////////////////
			InputStream is = (InputStream) response.getEntity();
			FTPResult = writeFileToFTP(is, ftpURL, ftpPort, ftpUser, ftpPassword, fileName);
			log.debug("FTP Result For File Saving:" + FTPResult);
			if (is != null)
				is.close();
		} catch (Exception e) {
			log.error("Error!", e);
			FTPResult = false;
		}
		return FTPResult;

	}

	boolean writeFileToFTP(InputStream stream, String ftpUrl, Integer ftpPort, String ftpUser, String ftpPassword,
			String fileName) {
		boolean result = false;
		FTPClient ftpClient = new FTPClient();

		try {
			ftpClient.connect(ftpUrl, ftpPort);
			boolean loginr = ftpClient.login(ftpUser, ftpPassword);
			ftpClient.enterLocalPassiveMode();

			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			log.debug("FTP LOGIN STATUS :" + loginr);
			result = ftpClient.storeFile(fileName, stream);
			if (result) {
				log.debug("The file is uploaded successfully.");
				// System.out.println("The file is uploaded successfully.");
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			result = false;
			log.debug("SocketException");
			log.debug("Exception: {}", e.getMessage());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			result = false;
			log.debug("FileNotFoundException");
			log.debug("Exception: {}", e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			result = false;
			log.debug("Exception: {}", e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (ftpClient.isConnected()) {
					ftpClient.logout();
					ftpClient.disconnect();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		return result;

	}
}
