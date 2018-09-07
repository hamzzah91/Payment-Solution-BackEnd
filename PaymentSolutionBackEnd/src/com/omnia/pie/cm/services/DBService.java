package com.omnia.pie.cm.services;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import com.omnia.pie.utility.hibernate.PasswordCryptorHelper;

public class DBService {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());
	private String password = null;
	private boolean passEncrypted = true;
	private String keyPath = null;

	public DBService(){
		Resource resource = new ClassPathResource("/remitnow.properties");
		Properties propertiesUtil;
		try {
			propertiesUtil = PropertiesLoaderUtils.loadProperties(resource);
			passEncrypted = Boolean.valueOf(propertiesUtil.getProperty("jdbc.passEncryted"));
			password = propertiesUtil.getProperty("jdbc.pass");			
			keyPath = propertiesUtil.getProperty("security.keyPath");
			
			log.debug("Preparing DB Service");
			log.debug("Is Encryted? {}", passEncrypted);
			log.debug("Password Length: {}", password.length());
			
		} catch (IOException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	
	public String getPassword() {
		try {
			if (passEncrypted){
				PasswordCryptorHelper helper = new PasswordCryptorHelper();
				password = helper.Decrypt(keyPath, password);
				log.debug("Decryption successful");
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return password;
	}

}
