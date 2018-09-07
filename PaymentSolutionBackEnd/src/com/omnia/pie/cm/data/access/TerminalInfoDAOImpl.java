package com.omnia.pie.cm.data.access;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.omnia.pie.base.dao.BaseDAOImpl;
import org.springframework.transaction.annotation.Transactional;

import com.omnia.pie.cm.data.model.Channel;
import com.omnia.pie.cm.data.model.Customer;
import com.omnia.pie.cm.data.model.TerminalInfo;

/**
 * @see com.omnia.pie.cm.data.model.TerminalInfo
 * @author M Louie
 */

@Transactional
public class TerminalInfoDAOImpl extends BaseDAOImpl<TerminalInfo> implements TerminalInfoDAO {

	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

	public TerminalInfoDAOImpl() {
		super(TerminalInfo.class);
	}


	@Override
	public List<String> searchTerminalNamesByChannelCustomer(final Channel channel, final Customer customer) {
		
		List<TerminalInfo> resultList = searchTerminalByChannelCustomer(channel, customer);
		List<String> resultListStr = new ArrayList<String>(resultList.size());
		for(TerminalInfo terminal : resultList){
			resultListStr.add(terminal.getTerminalId());
		}
		
		return resultListStr;
	}

	@Override
	public List<TerminalInfo> searchTerminalByChannelCustomer(final Channel channel, final Customer customer) {
		
		List<TerminalInfo> resultList = null;
		try {
			
			final StringBuilder hql = new StringBuilder();
			hql.append(" from TerminalInfo e");
			hql.append(" where e.channel.id = :channel ");
			hql.append(" and e.customer.id = :customer ");
			hql.append(" order by e.terminalId asc ");
			
			log.trace("Executing Query: [{}] with parameters [{}, {}]", hql.toString(), channel, customer);
			
			Query query = getEntityManager().createQuery(hql.toString());
			query.setParameter("channel", channel.getId());
			query.setParameter("customer", customer.getId());
			resultList = (List<TerminalInfo>) query.getResultList();
			
		} catch (Exception e) {
			
			resultList = new ArrayList<TerminalInfo>(0);
			log.debug("Exception occurred during query searchTerminalByChannelCustomer({}, {})", channel.getChannelName(), customer.getName());
			log.debug("Exception: {}", e.getMessage());
		}
		
		return resultList;
	}


	@Override
	public TerminalInfo searchByTerminalId(String terminalId) {
		TerminalInfo resultTerminalInfo = null;
		List<TerminalInfo> resultTerminalInfoList = null;
		try {
			
			final StringBuilder hql = new StringBuilder();
			hql.append(" from TerminalInfo e");
			hql.append(" where e.terminalId = :terminalId ");
			
			log.trace("Executing Query: [{}] with parameter [{}]", hql.toString(), terminalId);
			
			Query query = getEntityManager().createQuery(hql.toString());
			query.setParameter("terminalId", terminalId);
			resultTerminalInfoList = (List<TerminalInfo>) query.getResultList();
			if (!resultTerminalInfoList.isEmpty())
				resultTerminalInfo = resultTerminalInfoList.get(0);
			
		} catch (Exception e) {
			
			resultTerminalInfo = new TerminalInfo();
			log.error("Exception occurred during query searchByTerminalId({})", terminalId);
			log.debug("Exception: ", e);
		}
		
		return resultTerminalInfo;
	}
	
	@SuppressWarnings("unchecked")
	  public List<TerminalInfo> findByProperty(String propertyName, final Object value,
	      final int... rowStartIdxAndCount) {
	    log.info("finding TerminalInfo instance with property: " + propertyName + ", value: " + value);
	    try {
	      final String queryString = "select model from TerminalInfo model where model." + propertyName
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