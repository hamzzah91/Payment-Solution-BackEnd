package com.omnia.pie.cm.data.access;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.omnia.pie.base.dao.BaseDAOImpl;
import org.springframework.transaction.annotation.Transactional;

import com.omnia.pie.cm.data.model.UserGroup;

/**
 * @see com.omnia.pie.cm.data.model.UserGroup
 * @author M Louie
 */

@Transactional
public class UserGroupDAOImpl extends BaseDAOImpl<UserGroup> implements UserGroupDAO {

	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

	public UserGroupDAOImpl() {

		super(UserGroup.class);
	}

	@Override
	public List<UserGroup> searchAllByGroupCode(String groupCode) {
		List<UserGroup> resultList = null;
		try {
			
			final StringBuilder hql = new StringBuilder();
			hql.append(" from UserGroup e");
			hql.append(" where e.groupCategoryCode = :grpCode ");
			hql.append(" order by e.name asc ");
			
			log.trace("Executing Query: [{}] with parameters [{}]", hql.toString(), groupCode);
			
			Query query = getEntityManager().createQuery(hql.toString());
			query.setParameter("grpCode", groupCode);
			resultList = (List<UserGroup>) query.getResultList();
			
		} catch (Exception e) {
			
			resultList = new ArrayList<UserGroup>(0);
			log.debug("Exception occurred during query searchAllByGroupCode({})", groupCode);
			log.debug("Exception: {}", e.getMessage());
		}
		
		return resultList;
	}

	@Override
	public List<UserGroup> searchByNameByGroupCode(String name, String groupCode) {
		List<UserGroup> resultList = null;
		
		try {
			
			final StringBuilder hql = new StringBuilder();
			hql.append(" from UserGroup e");
			hql.append(" where e.name = :name ");
			hql.append(" and e.groupCategoryCode = :grpCode ");
			
			log.trace("Executing Query: [{}] with parameters [{}, {}]", hql.toString(), name, groupCode);
			
			Query query = getEntityManager().createQuery(hql.toString());
			query.setParameter("grpCode", groupCode);
			query.setParameter("name", name);
			resultList = (List<UserGroup>) query.getResultList();
			
		} catch (Exception e) {
			
			resultList = new ArrayList<UserGroup>(0);
			log.debug("Exception occurred during query searchAllVTMCustomer({}, {})", name, groupCode);
			log.debug("Exception: {}", e.getMessage());
		}
		
		return resultList;
	
	}

}