package com.omnia.pie.cm.data.access;

import java.util.List;

import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.omnia.pie.base.dao.BaseDAOImpl;
import org.springframework.transaction.annotation.Transactional;

import com.omnia.pie.cm.data.model.Branch;

/**
 * @see com.omnia.pie.cm.data.model.Branch
 * @author M Louie
 */

@Transactional
public class BranchDAOImpl extends BaseDAOImpl<Branch> implements BranchDAO {

	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

	public BranchDAOImpl() {

		super(Branch.class);
	}
	
	@SuppressWarnings("unchecked")
	  public List<Branch> findByProperty(String propertyName, final Object value,
	      final int... rowStartIdxAndCount) {
	    log.info("finding Branchs instance with property: " + propertyName + ", value: " + value);
	    try {
	      final String queryString = "select model from Branch model where model." + propertyName
	          + "= :propertyValue";
	      Query query = getEntityManager().createQuery(queryString);
	      query.setParameter("propertyValue", value);
	      if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
	        int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
	        if (rowStartIdx > 0) {
	          query.setFirstResult(rowStartIdx);
	        }

	        if (rowStartIdxAndCount.length > 1) {
	          int rowCount = Math.max(0, rowStartIdxAndCount[1]);
	          if (rowCount > 0) {
	            query.setMaxResults(rowCount);
	          }
	        }
	      }
	      return query.getResultList();
	    } catch (RuntimeException re) {
	      log.error("find by property name failed", re);
	      throw re;
	    }
	  }

}