package com.omnia.pie.cm.data.access;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.omnia.pie.base.dao.BaseDAOImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.omnia.pie.cm.data.model.UserGroup;
import com.omnia.pie.cm.data.model.UserGroupPermissionDirectory;
import com.omnia.pie.cm.data.model.UserGroupPermissionType;

/**
 * @see com.omnia.pie.cm.data.model.UserGroupPermissionDirectory
 * @author M Louie
 */

@Transactional
public class UserGroupPermissionDirectoryDAOImpl extends BaseDAOImpl<UserGroupPermissionDirectory> implements UserGroupPermissionDirectoryDAO {

	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private UserGroupPermissionTypeDAO userGroupPermissionTypeDao;
	
	public UserGroupPermissionDirectoryDAOImpl() {
		super(UserGroupPermissionDirectory.class);
	}

	@Override
	public List<UserGroupPermissionDirectory> searchPermissionDirectoryByGroup(UserGroup userGroup) {
		List<UserGroupPermissionDirectory> resultUserGroupPermissionDirectoryList = null;
		
		try {
			final StringBuilder hql = new StringBuilder();
			hql.append(" from UserGroupPermissionDirectory e");
			hql.append(" where e.userGroup.id = :userGroupId ");

			log.trace("Executing Query: [{}] with parameters [-]", hql.toString());
			
			Query query = getEntityManager().createQuery(hql.toString());
			query.setParameter("userGroupId", userGroup.getId());

			resultUserGroupPermissionDirectoryList = query.getResultList();
			
		} catch (Exception e) {
			
			log.error("Exception occurred during query searchPermissionDirectoryByGroup()");
			log.debug("Exception: ", e);
		}
		
		return resultUserGroupPermissionDirectoryList;
	}

	@Override
	public boolean removePermissionFromGroup(UserGroup userGroup, List<UserGroupPermissionType> permissionTypeList) {
		List<Long> idList = new ArrayList<Long>();
		permissionTypeList.forEach(v -> idList.add(Long.valueOf(v.getId())));
		
		try {
			final StringBuilder hql = new StringBuilder();
			hql.append(" delete UserGroupPermissionDirectory e");
			hql.append(" where e.userGroup.id = :userGroupId ");
			hql.append(" and e.userGroupPermission.id in (?1) ");

			log.trace("Executing Query: [{}] with parameters [{}, ids={}]", hql.toString(), userGroup.getName(), idList.size());
			
			Query query = getEntityManager().createQuery(hql.toString());
			query.setParameter("userGroupId", userGroup.getId());
			query.setParameter(1, idList);

			int result = query.executeUpdate();

			log.debug("Query result: {}", result);
			
			if (result > 0)
				return true;
			else
				return false;
			
		} catch (Exception e) {
			
			log.error("Exception occurred during query removePermissionFromGroup()");
			log.debug("Exception: ", e);
		}
		
		return false;
	}

	@Override
	public boolean addPermissionFromGroup(UserGroup userGroup, List<UserGroupPermissionType> permissionTypeList) {

		UserGroupPermissionDirectory itm = null;
		try {
			for (UserGroupPermissionType type : permissionTypeList){
				itm = new UserGroupPermissionDirectory();
				itm.setUserGroup(userGroup);
				itm.setUserGroupPermission(userGroupPermissionTypeDao.findById(type.getId()));
				save(itm);
			}
			return true;
		} catch (Exception e) {
			log.error("Error encountered: {}", e.getMessage());
			return false;
		}
		
		
	}


}