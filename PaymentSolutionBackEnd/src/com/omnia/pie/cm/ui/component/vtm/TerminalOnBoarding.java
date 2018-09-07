package com.omnia.pie.cm.ui.component.vtm;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.omnia.pie.cm.data.access.BranchDAO;
import com.omnia.pie.cm.data.access.TerminalInfoDAO;
import com.omnia.pie.cm.data.model.Branch;
import com.omnia.pie.cm.ui.model.vtm.TerminalInformation;
import com.omnia.pie.cm.ui.util.SpringScopeView;

@Component(value="terminalOnBoarding")
@ManagedBean
@SessionScoped
@SpringScopeView
public class TerminalOnBoarding implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

	private TerminalInformation terminalInfo = new TerminalInformation();
	private List<String> branchs;
	private String branch;
	private List<Branch> allSearchedBranches = new ArrayList<Branch>();
	private Properties propertiesUtil;
	private String customerId;
	private String channelId;
	private String serverAgentType;
	private String antiSkimmingOccurrence;
	private String antiSkimmingSchedule;
	private String logUploadOccurrence;
	private String logUploadSchedule;
	private String logUploadDestPath;
	private String logUploadDestPort;
	private String logUploadDestUsername;
	private String logUploadDestPassword;
	private String EJUploadOccurrence;
	private String EJUploadSchedule;
	private String EJUploadDestPath;
	private String EJUploadDestPort;
	private String EJUploadDestUsername;
	private String EJUploadDestPassword;
	private String terminalEventBranch;
	private String terminalEventType;
	private String terminalEventValue;
	private String terminalEventTimestamp;
	private String serverAgentAliveStatus;
	private String serverAgentLastSeen;
	private String serverAgentTrackerID;
	private String cashCoinStatusDeviceIds;
	private String cashCoinStatusLastLowcountTimestamp;
	private String cashCoinStatusLowcountAlertSentCount;
	private String cashCoinStatusLastOutcountTimestamp;
	private String cashCoinStatusOutcountAlertSentCount;
	private String cashCoinstatusTrackerID;
	private String cashCoinStatusArchived;
	
	private String cashCoinLevelDeviceIds;
	private String cashCoinLevelCassetteNamesDeviceCoinDispenser;
	private String cashCoinLevelCassetteNamesDeviceCashDispenser;
	private String cashCoinLevelCassetteNamesDeviceCardReader;
	private String cashCoinLevelCassetteNamesDeviceChequeAcceptor;
	private String cashCoinLevelCassetteNamesDeviceCashAcceptor;
	private String cashCoinLevelCassetteDenominationCoinDispenser;
	private String cashCoinLevelCassetteDenominationCashDispenser;
	private String cashCoinLevelCassetteDenominationCardReader;
	private String cashCoinLevelCassetteDenominationChequeAcceptor;
	private String cashCoinLevelCassetteDenominationCashAcceptor;
	private String cashCoinLevelCashLevelCoinDispenser;
	private String cashCoinLevelCashLevelCashDispenser;
	private String cashCoinLevelCashLevelCardReader;
	private String cashCoinLevelCashLevelChequeAcceptor;
	private String cashCoinLevelCashLevelCashAcceptor;
	
	//private String onlineStatusDeviceIds;
	private String onlineStatusArchived;
	private String onlineStatus;
	private String onlineStatustrackerId;
	private String terminalAddPieDBUrl;
	private String terminalAddPieDBEndPoint;
	private String terminalAddPermission;
	@Autowired
	TerminalInfoDAO terminalInfoDao;
	
	
	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	@Autowired
	private BranchDAO branchDao;
	
	
	

	
	public List<String> getBranchs() {
		return branchs;
	}

	public void setBranchs(List<String> branchs) {
		this.branchs = branchs;
	}

	public TerminalInformation getTerminalInfo() {
		return terminalInfo;
	}

	public void setTerminalInfo(TerminalInformation terminalInfo) {
		this.terminalInfo = terminalInfo;
	}
	
public TerminalOnBoarding() {
		
		try {
			log.debug("Reading properties file for business rule endpoint and notification service endpoint..");
			Resource resource = new ClassPathResource("/remitnow.properties");
			propertiesUtil = PropertiesLoaderUtils.loadProperties(resource);
			customerId = propertiesUtil.getProperty("customer.id");
			channelId = propertiesUtil.getProperty("channel.id");
			
			serverAgentType = propertiesUtil.getProperty("server.agent.type");
			
			antiSkimmingOccurrence = propertiesUtil.getProperty("customer.antiSkimming.occurrence");
			antiSkimmingSchedule = propertiesUtil.getProperty("customer.antiSkimming.schedule.time");
			
			logUploadOccurrence = propertiesUtil.getProperty("customer.logUpload.occurrence");
			logUploadSchedule = propertiesUtil.getProperty("customer.logUpload.schedule.time");
			logUploadDestPath = propertiesUtil.getProperty("customer.logUpload.destination.path");
			logUploadDestPort = propertiesUtil.getProperty("customer.logUpload.destination.port");
			logUploadDestUsername = propertiesUtil.getProperty("customer.logUpload.destination.user.name");
			logUploadDestPassword = propertiesUtil.getProperty("customer.logUpload.destination.password");

			EJUploadOccurrence = propertiesUtil.getProperty("customer.EJUpload.occurrence");
			EJUploadSchedule = propertiesUtil.getProperty("customer.EJUpload.schedule.time");
			EJUploadDestPath = propertiesUtil.getProperty("customer.EJUpload.destination.path");
			EJUploadDestPort = propertiesUtil.getProperty("customer.EJUpload.destination.port");
			EJUploadDestUsername = propertiesUtil.getProperty("customer.EJUpload.destination.user.name");
			EJUploadDestPassword = propertiesUtil.getProperty("customer.EJUpload.destination.password");
			terminalEventBranch = propertiesUtil.getProperty("terminal.events.branch");
			terminalEventType = propertiesUtil.getProperty("terminal.events.eventType");
			terminalEventValue = propertiesUtil.getProperty("terminal.events.eventValue");
			terminalEventTimestamp = propertiesUtil.getProperty("terminal.events.eventTimestamp");
			
			serverAgentAliveStatus = propertiesUtil.getProperty("serverAgent.connection.status.aliveStatus");
			serverAgentLastSeen = propertiesUtil.getProperty("serverAgent.connection.status.lastSeen");
			serverAgentTrackerID = propertiesUtil.getProperty("serverAgent.connection.status.trackerID");
			
			cashCoinStatusDeviceIds = propertiesUtil.getProperty("cashCoin.status.device.id");
			cashCoinStatusLastLowcountTimestamp= propertiesUtil.getProperty("cashCoin.status.last_lowcount_timestamp");
			cashCoinStatusLowcountAlertSentCount= propertiesUtil.getProperty("cashCoin.status.lowcount_alert_sent_count");
			cashCoinStatusLastOutcountTimestamp= propertiesUtil.getProperty("cashCoin.status.last_outcount_timestamp");
			cashCoinStatusOutcountAlertSentCount= propertiesUtil.getProperty("cashCoin.status.outcount_alert_sent_count");
			cashCoinstatusTrackerID= propertiesUtil.getProperty("cashCoin.status.trackerID");
			cashCoinStatusArchived= propertiesUtil.getProperty("cashCoin.status.archived");
			
			cashCoinLevelDeviceIds = propertiesUtil.getProperty("cashCoin.level.device.id");
			cashCoinLevelCassetteNamesDeviceCoinDispenser = propertiesUtil.getProperty("cashCoin.level.device.cassetteName.CoinDispenser");
			cashCoinLevelCassetteNamesDeviceCashDispenser = propertiesUtil.getProperty("cashCoin.level.device.cassetteName.CashDispenser");
			cashCoinLevelCassetteNamesDeviceCardReader = propertiesUtil.getProperty("cashCoin.level.device.cassetteName.CardReader");
			cashCoinLevelCassetteNamesDeviceChequeAcceptor = propertiesUtil.getProperty("cashCoin.level.device.cassetteName.ChequeAcceptor");
			cashCoinLevelCassetteNamesDeviceCashAcceptor = propertiesUtil.getProperty("cashCoin.level.device.cassetteName.CashAcceptor");
			cashCoinLevelCassetteDenominationCoinDispenser = propertiesUtil.getProperty("cashCoin.level.device.cassetteDenomination.CoinDispenser");
		    cashCoinLevelCassetteDenominationCashDispenser = propertiesUtil.getProperty("cashCoin.level.device.cassetteDenomination.CashDispenser");
			cashCoinLevelCassetteDenominationCardReader = propertiesUtil.getProperty("cashCoin.level.device.cassetteDenomination.CardReader");
			cashCoinLevelCassetteDenominationChequeAcceptor = propertiesUtil.getProperty("cashCoin.level.device.cassetteDenomination.ChequeAcceptor");
			cashCoinLevelCassetteDenominationCashAcceptor = propertiesUtil.getProperty("cashCoin.level.device.cassetteDenomination.CashAcceptor");
			cashCoinLevelCashLevelCoinDispenser = propertiesUtil.getProperty("cashCoin.level.device.cashLevel.CoinDispenser");
			cashCoinLevelCashLevelCashDispenser = propertiesUtil.getProperty("cashCoin.level.device.cashLevel.CashDispenser");
			cashCoinLevelCashLevelCardReader = propertiesUtil.getProperty("cashCoin.level.device.cashLevel.CardReader");
			cashCoinLevelCashLevelChequeAcceptor = propertiesUtil.getProperty("cashCoin.level.device.cashLevel.ChequeAcceptor");
			cashCoinLevelCashLevelCashAcceptor = propertiesUtil.getProperty("cashCoin.level.device.cashLevel.CashAcceptor");
			
			

			//onlineStatusDeviceIds = propertiesUtil.getProperty("onlineStatus.vtm.devices.id");
			onlineStatusArchived= propertiesUtil.getProperty("onlineStatus.archived");
			onlineStatus= propertiesUtil.getProperty("onlineStatus.status");
			onlineStatustrackerId= propertiesUtil.getProperty("onlineStatus.trackerId");
			
			terminalAddPieDBUrl = propertiesUtil.getProperty("pie.db.add.terminal");
			terminalAddPieDBEndPoint = propertiesUtil.getProperty("pie.db.add.terminal.endpoint");
			terminalAddPermission = propertiesUtil.getProperty("pie.db.add.terminal.permission");
			
			log.debug("pie.db.add.terminal: {}", terminalAddPieDBUrl);
			log.debug("pie.db.add.terminal.endpoint: {}", terminalAddPieDBEndPoint);
			log.debug("pie.db.add.terminal.permission: {}", terminalAddPermission);

			log.debug("customer.id: {}", customerId);
			log.debug("channel.id: {}", channelId);
			log.debug("server.agent.type: {}", serverAgentType);
			log.debug("customer.antiSkimming.occurrence: {}", antiSkimmingOccurrence);
			log.debug("customer.antiSkimming.schedule.time: {}", antiSkimmingSchedule);
			
			log.debug("customer.logUpload.occurrence: {}", logUploadOccurrence);
			log.debug("customer.logUpload.schedule.time: {}", logUploadSchedule);
			log.debug("customer.logUpload.destination.path: {}", logUploadDestPath);
			log.debug("customer.logUpload.destination.port: {}", logUploadDestPort);
			log.debug("customer.logUpload.destination.user.name: {}", logUploadDestUsername);
			log.debug("customer.logUpload.destination.password: {}", logUploadDestPassword);

			log.debug("terminal.events.branch: {}", terminalEventBranch);
			log.debug("terminal.events.eventType: {}", terminalEventType);
			log.debug("terminal.events.eventValue: {}", terminalEventValue);
			
			log.debug("serverAgent.connection.status.aliveStatus: {}", serverAgentAliveStatus);
			log.debug("serverAgent.connection.status.lastSeen: {}", serverAgentLastSeen);
			log.debug("serverAgent.connection.status.trackerID: {}", serverAgentTrackerID);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	 @PostConstruct
	 public void init() {
		 branchs  = new ArrayList<String>();
		 allSearchedBranches = branchDao.findAll();
		 for(Branch b : allSearchedBranches)
		 {
		// branchs.put(b.getId().toString()+"key", b.getBranchName()+"value");
		 branchs.add(b.getBranchCode());
		 }
		// branchs.put("test","Test");
			
		 //System.err.println("got the tid from the page :"+terminalID);
	 }
	 public void onBranchChange() {
		// System.err.println("on branch change called ");
		 if(branch !=null)
		 {
			 //System.err.println("selected branch is : "+ branch);
		 }
	}
	 @Transactional
	public void saveTerminal()
	{}
}
