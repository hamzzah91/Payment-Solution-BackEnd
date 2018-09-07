package com.omnia.pie.cm.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.omnia.pie.cm.data.access.UserGroupDAO;
import com.omnia.pie.cm.data.access.UserGroupPermissionDirectoryDAO;
import com.omnia.pie.cm.data.access.UserGroupPermissionTypeDAO;
import com.omnia.pie.cm.data.model.UserGroup;
import com.omnia.pie.cm.data.model.UserGroupPermissionDirectory;
import com.omnia.pie.cm.data.model.UserGroupPermissionType;
import com.omnia.pie.cm.ui.model.vtm.GrpPermissionUI;
import com.omnia.pie.cm.ui.model.vtm.UserGroupUI;

@Transactional
@Service ("permissionService")
public class PermissionServiceImpl implements PermissionService {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	private UserGroupPermissionTypeDAO userGroupPermissionTypeDao;
	
	@Autowired
	private UserGroupPermissionDirectoryDAO userGroupPermissionDirectoryDao;
	
	@Autowired
	private UserGroupDAO userGroupDao;
	
	

	@Override
	public List<GrpPermissionUI> listGroupPermission() {
		List<GrpPermissionUI> permissionListUI = new ArrayList<GrpPermissionUI>();
		List<UserGroupPermissionType> permissionTypeList = userGroupPermissionTypeDao.findAll();
		permissionTypeList.sort(Comparator.comparing(UserGroupPermissionType::getPermission, String.CASE_INSENSITIVE_ORDER));
		
		if (permissionTypeList != null && !permissionTypeList.isEmpty()){
			permissionTypeList.forEach(v -> {
				permissionListUI.add(new GrpPermissionUI(v.getId(), v.getPermission(), v.getDescription()));
			});
		}
		return permissionListUI;
	}



	@Override
	public List<UserGroupUI> listVtmCustomerUserGroup() {
		List<UserGroupUI> listUI = new ArrayList<UserGroupUI>();
		List<UserGroup> list = userGroupDao.searchAllByGroupCode(UserGroupCode.VTM_CUSTOMER.toString());
		if (list != null && !list.isEmpty()){
			list.forEach(v -> {
				UserGroupUI ui = new UserGroupUI();
				ui.setId(v.getId());
				ui.setName(v.getName());
				ui.setGrpCode(v.getGroupCategoryCode());
				listUI.add(ui);
			});
		}
		return listUI;
	}


	
	@Override
	public List<GrpPermissionUI> listAllowedGroupPermission(final UserGroupUI userGroupUI) {
		List<GrpPermissionUI> resultList = new ArrayList<GrpPermissionUI>();
		UserGroup paramUserGroup = new UserGroup(userGroupUI.getId(), userGroupUI.getName());
		List<UserGroupPermissionDirectory> directoryList = userGroupPermissionDirectoryDao.searchPermissionDirectoryByGroup(paramUserGroup);
		if (directoryList != null && !directoryList.isEmpty()){
			for (UserGroupPermissionDirectory permissionDir : directoryList){
				UserGroupPermissionType type = permissionDir.getUserGroupPermission();
				GrpPermissionUI ui = new GrpPermissionUI(type.getId(), type.getPermission(), type.getDescription());
				resultList.add(ui);
			}
			resultList.sort(Comparator.comparing(GrpPermissionUI::getPermission, String.CASE_INSENSITIVE_ORDER));
		}
		
		return resultList;
	}



	@Override
	public boolean saveNewVTMUserGroup(String groupName) {
		boolean result = false;
		UserGroup userGroup = new UserGroup();
		userGroup.setName(groupName);
		userGroup.setGroupCategoryCode(UserGroupCode.VTM_CUSTOMER.toString());
		try {
			userGroupDao.searchByNameByGroupCode(groupName, UserGroupCode.VTM_CUSTOMER.toString());
			userGroupDao.save(userGroup);
			result = true;
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		return result;
	}



	@Override
	public boolean updateVTMUserGroup(UserGroupUI userGroupUI) {
		boolean result = false;
		UserGroup userGroup = userGroupDao.findById(userGroupUI.getId());
		
		if (userGroup == null)
			return result;
			
		userGroup.setName(userGroupUI.getName());
		try {
			userGroupDao.update(userGroup);
			result = true;
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		return result;
	}



	@Override
	public boolean updateGroupPermission(UserGroupUI userGroupUI, List<GrpPermissionUI> permissionList) {
		
		if (permissionList != null && !permissionList.isEmpty()){
			
			UserGroup ug = userGroupDao.findById(userGroupUI.getId());
			
			List<UserGroupPermissionType> currentPermissionList = userGroupPermissionTypeDao.searchPermissionByGroup(ug);
			
			UserGroupPermissionType pType = null;
			List<UserGroupPermissionType> newPermissionList = new ArrayList<UserGroupPermissionType>();
			List<UserGroupPermissionType> toretainPermissionList = new ArrayList<UserGroupPermissionType>();
			
			if (currentPermissionList != null && !currentPermissionList.isEmpty()){
				
				userGroupPermissionTypeDao.detachList(currentPermissionList);	//removing from the session
				
				for(GrpPermissionUI gp : permissionList){
					if (gp.isAllowed()){
						
						for (UserGroupPermissionType gpt : currentPermissionList){
							if (gpt.getId() == gp.getId()){
								toretainPermissionList.add(gpt);
								log.debug("To retain {}:{}", gpt.getId(), gpt.getPermission());
							}
						}
					}
					
				}
				
				// after removing the group that will be retain, the ones left will be deleted
				currentPermissionList.removeAll(toretainPermissionList);
			}
			
			log.debug("Retained permission has {} record", toretainPermissionList.size());
			
			for(GrpPermissionUI gp : permissionList){
					
				if (gp.isAllowed()){
					
					log.debug("Count of existing: {} for {}", toretainPermissionList.stream().filter(perm -> perm.getId() == gp.getId()).count(), gp.getPermission());
					
					//check if the permission is already existing so it will not be duplicated
					if (toretainPermissionList.stream().filter(perm -> perm.getId() == gp.getId()).count() > 0){
						log.info("Will retain existing permission: {}", gp.getPermission());
					}else{
						pType = new UserGroupPermissionType();
						pType.setId(gp.getId());
						pType.setPermission(gp.getPermission());
						newPermissionList.add(pType);
					}
					
					
				}
			}
			
			if(currentPermissionList != null && !currentPermissionList.isEmpty()){
				userGroupPermissionDirectoryDao.removePermissionFromGroup(ug, currentPermissionList);
				currentPermissionList.forEach(v -> log.debug("Removing: {}", v.getPermission()));
			}
				
			
			if(!newPermissionList.isEmpty()){
				userGroupPermissionDirectoryDao.addPermissionFromGroup(ug, newPermissionList);
				newPermissionList.forEach(v -> log.debug("Adding: {}", v.getPermission()));
			}
				
			
			
		}
		
		return false;
	}
	
}
