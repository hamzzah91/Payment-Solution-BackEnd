package com.omnia.pie.cm.data.access;

import java.util.List;

import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.omnia.pie.base.dao.BaseDAOImpl;
import org.springframework.transaction.annotation.Transactional;

import com.omnia.pie.cm.data.model.UserGroup;
import com.omnia.pie.cm.data.model.UserGroupPermissionDirectory;
import com.omnia.pie.cm.data.model.UserGroupPermissionType;

/**
 * @see com.omnia.pie.cm.data.model.UserGroupPermissionType
 * @author M Louie
 */

@Transactional
public class UserGroupPermissionTypeDAOImpl extends BaseDAOImpl<UserGroupPermissionType> implements UserGroupPermissionTypeDAO {

	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

	public UserGroupPermissionTypeDAOImpl() {

		super(UserGroupPermissionType.class);
	}

	@Override
	public List<UserGroupPermissionType> searchPermissionByGroup(UserGroup userGroup) {
		List<UserGroupPermissionType> userGroupPermissionTypeList = null;
		
		try {
			final StringBuilder hql = new StringBuilder();
			hql.append(" select d");
			hql.append(" from UserGroupPermissionDirectory e");
			hql.append(" join e.userGroupPermission d");
			hql.append(" where e.userGroup.id = :userGroupId ");

			log.trace("Executing Query: [{}] with parameters [{}]", hql.toString(), userGroup.getName());
			
			Query query = getEntityManager().createQuery(hql.toString());
			query.setParameter("userGroupId", userGroup.getId());

			userGroupPermissionTypeList = query.getResultList();

			log.debug("Query result: {}", userGroupPermissionTypeList);
		} catch (Exception e) {
			log.error("Error encountered: {}", e.getMessage());
			
		}
		
		return userGroupPermissionTypeList;
	}

}