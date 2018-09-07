package com.omnia.pie.cm.services;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.omnia.pie.utility.hibernate.PasswordCryptorHelper;

@Transactional
@Service ("cryptService")
public class CryptServiceImpl implements CryptService {

	private final static Logger log = LoggerFactory.getLogger(CryptServiceImpl.class);
	private static String keyPath;
	
	static{
		Resource resource = new ClassPathResource("/remitnow.properties");
		Properties propertiesUtil;
		try {
			propertiesUtil = PropertiesLoaderUtils.loadProperties(resource);
			keyPath = propertiesUtil.getProperty("security.keyPath");
			
			log.debug("Decryption/Encryption key path: {}", keyPath);
			
		} catch (IOException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	
	@Override
	public String encrypt(String text) {
		String encryptedText = null;
		try {
			PasswordCryptorHelper helper = new PasswordCryptorHelper();
			encryptedText = helper.Encrypt(keyPath, text);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return encryptedText;
	}

	@Override
	public String decrypt(String text) {
		String decryptedText = null;
		try {
			PasswordCryptorHelper helper = new PasswordCryptorHelper();
			decryptedText = helper.Decrypt(keyPath, text);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return decryptedText;
	}

	
}
