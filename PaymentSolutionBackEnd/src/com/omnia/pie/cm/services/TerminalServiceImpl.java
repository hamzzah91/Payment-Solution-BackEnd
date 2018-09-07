package com.omnia.pie.cm.services;

import static com.cronutils.model.CronType.QUARTZ;
import static com.cronutils.model.field.expression.FieldExpressionFactory.always;
import static com.cronutils.model.field.expression.FieldExpressionFactory.every;
import static com.cronutils.model.field.expression.FieldExpressionFactory.on;
import static com.cronutils.model.field.expression.FieldExpressionFactory.questionMark;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cronutils.builder.CronBuilder;
import com.cronutils.descriptor.CronDescriptor;
import com.cronutils.model.Cron;
import com.cronutils.model.definition.CronDefinitionBuilder;
import com.omnia.pie.cm.data.access.TerminalInfoDAO;
import com.omnia.pie.cm.data.model.Channel;
import com.omnia.pie.cm.data.model.Customer;
import com.omnia.pie.cm.data.model.TerminalInfo;

/**
 * @author M Louie
 *
 */

@Transactional
@Service ("terminalService")
public class TerminalServiceImpl implements TerminalService {

	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	private ParameterCheckService parameterCheckService;
	
	@Autowired
	private TerminalInfoDAO terminalInfoDao;
	
	
	

	@Override
	public List<String> listTerminalNamesByChannelCustomer(final Channel channel, final Customer customer) {
		if (parameterCheckService.isChannelCheckPassed(channel) && parameterCheckService.isCustomerCheckPassed(customer)){
			return terminalInfoDao.searchTerminalNamesByChannelCustomer(channel, customer);
		}else{
			return new ArrayList<String>(0);
		}
	}

	@Override
	public List<TerminalInfo> listTerminalByChannelCustomer(final Channel channel, final Customer customer) {
		return listTerminalByChannelCustomer(channel, customer, true);
	}

	@Override
	public List<TerminalInfo> listTerminalByChannelCustomer(final Channel channel, final Customer customer, boolean evictFromSession) {
		if (parameterCheckService.isChannelCheckPassed(channel) && parameterCheckService.isCustomerCheckPassed(customer)){
			
			List<TerminalInfo> terminalList = terminalInfoDao.searchTerminalByChannelCustomer(channel, customer);
			if (evictFromSession){
				terminalList = terminalInfoDao.detachList(terminalList);
			}
			
			return terminalList;
			
		}else{
			
			return new ArrayList<TerminalInfo>(0);
		}
	}

	


	
	@Override
	public Cron buildCron(String occurence, String scheduledTime) {
		// we are going to use cron schedule instead of date object schedule
		Cron cron = null;
		String[] sched = scheduledTime.split(":");
		int hour = Integer.parseInt(sched[0]);
		int minutes = Integer.parseInt(sched[1]);
		int seconds = 0;
		if (sched.length == 3){
			seconds = Integer.parseInt(sched[2]);
		}

		if (occurence.equalsIgnoreCase("DAILY")){
			cron = CronBuilder.cron(CronDefinitionBuilder.instanceDefinitionFor(QUARTZ))
					.withYear(always())
					.withDoM(questionMark())
					.withMonth(always())
					.withDoW(always())
					.withHour(on(hour))
					.withMinute(on(minutes))
					.withSecond(on(seconds))
					.instance();
		}else if (occurence.equalsIgnoreCase("HOURLY")){
			cron = CronBuilder.cron(CronDefinitionBuilder.instanceDefinitionFor(QUARTZ))
					.withYear(always())
					.withDoM(questionMark())
					.withMonth(always())
					.withDoW(always())
					.withHour(always())
					.withMinute(on(minutes))
					.withSecond(on(seconds))
					.instance();				
		}else if (occurence.equalsIgnoreCase("MINUTES")){
			cron = CronBuilder.cron(CronDefinitionBuilder.instanceDefinitionFor(QUARTZ))
					.withYear(always())
					.withDoM(questionMark())
					.withMonth(always())
					.withDoW(always())
					.withHour(always())
					.withMinute(every(minutes))
					.withSecond(on(seconds))
					.instance();
		}else if (occurence.equalsIgnoreCase("NOW")){
			//TODO: Correct cron 
			cron = CronBuilder.cron(CronDefinitionBuilder.instanceDefinitionFor(QUARTZ))
					.withYear(always())
					.withDoM(questionMark())
					.withMonth(always())
					.withDoW(always())
					.withHour(always())
					.withMinute(always())
					.withSecond(every(seconds))
					.instance();
		}else if (occurence.equalsIgnoreCase("ONE_TIME_SCHEDULE")){
			//TODO: Correct cron 
			cron = CronBuilder.cron(CronDefinitionBuilder.instanceDefinitionFor(QUARTZ))
					.withYear(always())
					.withDoM(questionMark())
					.withMonth(always())
					.withDoW(always())
					.withHour(always())
					.withMinute(always())
					.withSecond(every(seconds))
					.instance();		
		}else{
			cron = CronBuilder.cron(CronDefinitionBuilder.instanceDefinitionFor(QUARTZ))
					.withYear(always())
					.withDoM(questionMark())
					.withMonth(always())
					.withDoW(always())
					.withHour(always())
					.withMinute(always())
					.withSecond(every(seconds))
					.instance();
		}


		CronDescriptor cronDescriptor = CronDescriptor.instance(Locale.US);
		log.debug("Schedule on: cron={} | {}", cron.asString(), cronDescriptor.describe(cron));

		return cron;
	}


	}


	