package test.services;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.omnia.pie.cm.data.model.Channel;
import com.omnia.pie.cm.data.model.Customer;
import com.omnia.pie.cm.data.model.TerminalInfo;
import com.omnia.pie.cm.services.ParameterCheckService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class ParameterCheckServiceTest {


	@Autowired
	@Qualifier("parameterCheckService")
	ParameterCheckService parameterCheckService;
	

	@Test
	public void testIsChannelCheckPassed_when_channel_isnull() {
		Channel channel = null;
		assertFalse(parameterCheckService.isChannelCheckPassed(channel));
	}

	@Test
	public void testIsCustomerCheckPassed_when_customer_isnull() {
		Customer customer = null;
		assertFalse(parameterCheckService.isCustomerCheckPassed(customer));
	}

	@Test
	public void testIsTerminalCheckPassed_when_terminal_isnull() {
		TerminalInfo terminal = null;
		assertFalse(parameterCheckService.isTerminalCheckPassed(terminal));
	}

	@Test
	public void testIsChannelCheckPassed_when_channel_id_isnull() {
		Channel channel = new Channel();
		assertFalse(parameterCheckService.isChannelCheckPassed(channel));
	}

	@Test
	public void testIsCustomerCheckPassed_when_customer_id_isnull() {
		Customer customer = new Customer();
		assertFalse(parameterCheckService.isCustomerCheckPassed(customer));
	}

	@Test
	public void testIsTerminalCheckPassed_when_terminal_id_isnull() {
		TerminalInfo terminal = new TerminalInfo();
		assertFalse(parameterCheckService.isTerminalCheckPassed(terminal));
	}
	
	@Test
	public void testIsChannelCheckPassed_when_channel_name_isnull() {
		Channel channel = new Channel();
		channel.setId(1L);
		assertFalse(parameterCheckService.isChannelCheckPassed(channel));
	}

	@Test
	public void testIsCustomerCheckPassed_when_customer_name_isnull() {
		Customer customer = new Customer();
		customer.setId(1L);
		assertFalse(parameterCheckService.isCustomerCheckPassed(customer));
	}

	@Test
	public void testIsTerminalCheckPassed_when_terminal_terminalid_isnull() {
		TerminalInfo terminal = new TerminalInfo();
		terminal.setId(1L);
		assertFalse(parameterCheckService.isTerminalCheckPassed(terminal));
	}
	
	@Test
	public void testIsChannelCheckPassed_when_channel_should_passed() {
		Channel channel = new Channel();
		channel.setId(1L);
		channel.setChannelName("VTM");
		assertTrue(parameterCheckService.isChannelCheckPassed(channel));
	}

	@Test
	public void testIsCustomerCheckPassed_when_customer_should_pass() {
		Customer customer = new Customer();
		customer.setId(1L);
		customer.setName("Omnia");
		assertTrue(parameterCheckService.isCustomerCheckPassed(customer));
	}

	@Test
	public void testIsTerminalCheckPassed_when_terminal_should_pass() {
		TerminalInfo terminal = new TerminalInfo();
		terminal.setId(1L);
		terminal.setTerminalId("1001");
		assertTrue(parameterCheckService.isTerminalCheckPassed(terminal));
	}
	
	@Test
	public void isStringNotEmptyCheckPassed_when_it_should_pass() {
		assertTrue(parameterCheckService.isStringNotEmptyCheckPassed("string"));
	}
	
	@Test
	public void isStringNotEmptyCheckPassed_when_it_should_fail_with_empty_param() {
		assertFalse(parameterCheckService.isStringNotEmptyCheckPassed(""));
	}
	
	@Test
	public void isStringNotEmptyCheckPassed_when_it_should_fail_with_null_param() {
		assertFalse(parameterCheckService.isStringNotEmptyCheckPassed(null));
	}
	
	@Test
	public void isListNullOrEmptyCheckPassed_when_it_should_pass() {
		List<String> list = new ArrayList<String>();
		list.add("test value");
		assertTrue(parameterCheckService.isListNullOrEmptyCheckPassed(list));
	}
	
	@Test
	public void isListNullOrEmptyCheckPassed_when_it_should_fail_with_empty_param() {
		List<String> list = new ArrayList<String>();
		assertFalse(parameterCheckService.isListNullOrEmptyCheckPassed(list));
	}
	
	@Test
	public void isListNullOrEmptyCheckPassed_when_it_should_fail_with_null_param() {
		assertFalse(parameterCheckService.isListNullOrEmptyCheckPassed(null));
	}

	@Test
	public void validatePathIsTruePath_when_it_should_pass_forward_slash() {
		assertTrue(parameterCheckService.validatePathIsTruePath("127.0.0.1/VTM"));
	}
	
	@Test
	public void validatePathIsTruePath_when_it_should_pass_backward_slash() {
		assertTrue(parameterCheckService.validatePathIsTruePath("127.0.0.1\\VTM"));
	}
	
	@Test
	public void validatePathIsTruePath_when_it_should_fail_with_empty_param() {
		assertFalse(parameterCheckService.validatePathIsTruePath(""));
	}
	
	@Test
	public void validatePathIsTruePath_when_it_should_fail_with_invalid_path() {
		assertFalse(parameterCheckService.validatePathIsTruePath("127.0.0.1"));
	}
	
	@Test
	public void validatePathIsTruePath_when_it_should_fail_with_null_param() {
		assertFalse(parameterCheckService.validatePathIsTruePath(null));
	}
	
	@Test
	public void validateTimeScheduleIsTime_when_it_should_pass() {
		assertTrue(parameterCheckService.validateTimeScheduleIsTime("00:00:01"));
	}
	
	@Test
	public void validateTimeScheduleIsTime_when_it_should_fail_with_empty_param() {
		assertFalse(parameterCheckService.validateTimeScheduleIsTime(""));
	}
	
	@Test
	public void validateTimeScheduleIsTime_when_it_should_fail_with_null_param() {
		assertFalse(parameterCheckService.validateTimeScheduleIsTime(null));
	}
	
}
