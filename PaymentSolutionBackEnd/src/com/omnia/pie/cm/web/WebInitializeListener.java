package com.omnia.pie.cm.web;

import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.omnia.pie.cm.commserver.server.CommandServer;
import com.omnia.pie.utility.hibernate.PasswordCryptorHelper;

public class WebInitializeListener implements ServletContextListener {

	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		log.debug("Shuting down...");
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				CommandServer.getInstance().close();
			}
		}).start();
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		log.debug("Starting up...");

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Resource resource = new ClassPathResource("/remitnow.properties");
					Properties propertiesUtil = PropertiesLoaderUtils.loadProperties(resource);
					boolean useSSL = Boolean.valueOf(propertiesUtil.getProperty("commserver.useSSL"));
					int port = Integer.valueOf(propertiesUtil.getProperty("commserver.port"));
					
					String keyPath = propertiesUtil.getProperty("security.keyPath");
					String keystore = propertiesUtil.getProperty("security.keystore");
					String tmpKeypass = propertiesUtil.getProperty("security.keystorepass");
					String tmpCertPass = propertiesUtil.getProperty("security.certpass");
					
					PasswordCryptorHelper helper = new PasswordCryptorHelper();
					
					log.info("Decrypting keystore password...");
					String keyPass = helper.Decrypt(keyPath, tmpKeypass);
					log.info("Decrypting done...{}",(keyPass==null?"Failed":"Success"));
					log.info("Decrypting certificate password...");
					String certPass = helper.Decrypt(keyPath, tmpCertPass);
					log.info("Decrypting done...{}", (certPass==null?"Failed":"Success"));
					
					log.info("Instantiating CommandServer...");
					CommandServer server = CommandServer.getInstance();
					server.initialize(useSSL, port, keystore, keyPass, certPass);
					server.start();
					
					//server.subscribeConnection(new PortalServerSubscriber());
					
					ServletContext ctx = sce.getServletContext();
					WebApplicationContext springContext = WebApplicationContextUtils.getWebApplicationContext(ctx);
					/*PortalServerSubscriber portalServerSubscriber = (PortalServerSubscriber) springContext.getBean("portalServerSubscriber");
					server.subscribeConnection(portalServerSubscriber);
				*/	
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}).start();

	}

}
