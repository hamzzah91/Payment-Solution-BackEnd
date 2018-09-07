package com.omnia.pie.cm.web.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FTPUtil {
	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

	public boolean pushFileToFTP(String filePath, String fileName, String ftpUrl, Integer ftpPort, String ftpUser, String ftpPassword){
		try {
			File file = new File(filePath);
			InputStream stream = new FileInputStream(file);
			return writeFileToFTP(stream, ftpUrl, ftpPort, ftpUser, ftpPassword, fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			log.error(e.getMessage() + ":" + filePath);
			return false;
		}
	}
	
	public boolean writeFileToFTP(InputStream stream, String ftpUrl, Integer ftpPort, String ftpUser, String ftpPassword, String fileName) {
		
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
			}
		} catch (SocketException e) {
			result = false;
			log.debug("SocketException");
			log.debug("Exception: {}", e.getMessage());
		} catch (FileNotFoundException e) {
			result = false;
			log.debug("FileNotFoundException");
			log.debug("Exception: {}", e.getMessage());
		} catch (IOException e) {
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
