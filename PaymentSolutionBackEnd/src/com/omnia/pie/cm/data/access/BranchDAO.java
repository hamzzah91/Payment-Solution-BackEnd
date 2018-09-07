package com.omnia.pie.cm.data.access;

import java.util.List;

import com.omnia.pie.base.dao.BaseDAO;
import com.omnia.pie.cm.data.model.Branch;

/**
 * @see com.omnia.pie.cm.data.model.Branch
 * @author M Louie
 */

public interface BranchDAO extends BaseDAO<Branch> {

	  public List<Branch> findByProperty(String propertyName, Object value, int... rowStartIdxAndCount);

}