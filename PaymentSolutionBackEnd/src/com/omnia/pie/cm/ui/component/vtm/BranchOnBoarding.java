package com.omnia.pie.cm.ui.component.vtm;

import java.io.IOException;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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
import com.omnia.pie.cm.data.model.Channel;
import com.omnia.pie.cm.data.model.Customer;
import com.omnia.pie.cm.ui.model.vtm.BranchUI;
import com.omnia.pie.cm.ui.model.vtm.TerminalInformation;
import com.omnia.pie.cm.ui.util.SpringScopeView;

@Component(value="branchOnBoarding")
@ManagedBean
@SessionScoped
@SpringScopeView
public class BranchOnBoarding implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());
	

	@Autowired
	BranchDAO branchDao;
	private Properties propertiesUtil;
	private String customerId;
	private String channelId;
	private BranchUI branchUI = new BranchUI();
	private List<Branch> savedBranches = new ArrayList<>();
	private Branch selectedBranch;
	


	public Branch getSelectedBranch() {
		return selectedBranch;
	}

	public void setSelectedBranch(Branch selectedBranch) {
		this.selectedBranch = selectedBranch;
	}

	public List<Branch> getSavedBranches() {
		savedBranches = branchDao.findAll();
		//for(Branch b:savedBranches)
			//System.err.println(b.getBranchName());
		return savedBranches;
	}

	public void setSavedBranches(List<Branch> savedBranches) {
		this.savedBranches = savedBranches;
	}


	public BranchUI getBranchUI() {
		return branchUI;
	}


	public void setBranchUI(BranchUI branchUI) {
		this.branchUI = branchUI;
	}
	public BranchOnBoarding() {
		
		try {
			log.debug("Reading properties file for business rule endpoint and notification service endpoint..");
			Resource resource = new ClassPathResource("/remitnow.properties");
			propertiesUtil = PropertiesLoaderUtils.loadProperties(resource);
			customerId = propertiesUtil.getProperty("customer.id");
				
			channelId = propertiesUtil.getProperty("channel.id");
			
			log.debug("customer.id: {}", customerId);
			log.debug("channel.id: {}", channelId);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveTerminal()
	{
		//System.err.println("Save terminal called :"+branchUI.getBranchName());
		branchUI = new BranchUI();
	}
	@Transactional
	public void saveBranch()
	{
        FacesMessage msg = null;
		Branch branch = new Branch();
		branch.setBranchName(branchUI.getBranchName());
		branch.setBranchCode(branchUI.getBranchCode());
		branch.setBuilding(branchUI.getBuilding());
		branch.setStreet(branchUI.getStreet());
		branch.setCity(branchUI.getCity());
		branch.setCountry(branchUI.getCountry());
		Customer customer = new Customer();
		customer.setId(Long.valueOf(customerId));
		branch.setCustomer(customer);
		branch.setState(branchUI.getState());
		Channel channel = new Channel();
		channel.setId(Long.valueOf(channelId));
		branch.setChannel(channel);
		List<Branch> branchNameSearch = branchDao.findByProperty("branchName", branch.getBranchName());
		List<Branch> branchCodeSearch = branchDao.findByProperty("branchCode", branch.getBranchCode());
		
		if(!branchNameSearch.isEmpty() || !branchCodeSearch.isEmpty())
		{
			msg = new FacesMessage("Branch not saved,Branch Name or code already exists.");
		}
		else
		{
		try {
			branchDao.save(branch);
			msg = new FacesMessage("New Branch is saved");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg = new FacesMessage("Branch was not saved due to some error");
		}
		}
		FacesContext.getCurrentInstance().addMessage(null, msg); 
		branchUI = new BranchUI();
	}
	
	@Transactional
	public void updateBranch(Branch branch)
	{
		log.debug("updating branch info for :"+ branch.getBranchName() + " " + branch.getBranchCode());
        FacesMessage msg = null;
        /*Branch branch = new Branch();
		branch.setBranchName(branchUI.getBranchName());
		branch.setBranchCode(branchUI.getBranchCode());
		branch.setBuilding(branchUI.getBuilding());
		branch.setStreet(branchUI.getStreet());
		branch.setCity(branchUI.getCity());
		branch.setCountry(branchUI.getCountry());
		Customer customer = new Customer();
		customer.setId(Long.valueOf(customerId));
		branch.setCustomer(customer);
		branch.setState(branchUI.getState());
		Channel channel = new Channel();
		channel.setId(Long.valueOf(channelId));
		branch.setChannel(channel);
		List<Branch> branchNameSearch = branchDao.findByProperty("branchName", branch.getBranchName());
		List<Branch> branchCodeSearch = branchDao.findByProperty("branchCode", branch.getBranchCode());
		
		if(!branchNameSearch.isEmpty() || !branchCodeSearch.isEmpty())
		{
			msg = new FacesMessage("Branch not saved,Branch Name or code already exists.");
		}
		else
		{*/
		try {
			branchDao.update(branch);
			msg = new FacesMessage("Branch is updated");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg = new FacesMessage("Branch is not updated due to some error.");
		}
		//}
		FacesContext.getCurrentInstance().addMessage(null, msg); 
		//branchUI = new BranchUI();
	}	
}
