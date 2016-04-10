package com.oyeseva.business.service;

import java.util.Calendar;
import java.util.UUID;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oyeseva.entity.generated.Customer;

public class CustomerServiceTest {

	// Create Spring application context
	private static ClassPathXmlApplicationContext ctx;

	private static CustomerService userService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// mEntityManager.close();
		// mEmf.close();
	}

	@Before
	public void setUp() throws Exception {
		// Create Spring application context
		ctx = new ClassPathXmlApplicationContext("classpath:/spring.xml");

		// Get service from context. (service's dependency (ProductDAO) is
		// autowired in ProductService)
		userService = ctx.getBean(CustomerService.class);
	}

	@After
	public void tearDown() throws Exception {
		ctx.close();
	}

	@Test
	public final void testCustomer() {

		// Create the Customer
		Customer customer = new Customer();
		customer.setUuid(UUID.randomUUID().toString());
		String customer_status = "1";
		customer.setCustomerStatus(customer_status);
		customer.setCustomerChangeLog("Service tested");
		customer.setRegistrationVerificationCode(UUID.randomUUID().toString());
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 7); // expiry after 7 days from the date of
									// registration
		customer.setRegistrationVerificationCodeExpiresBy(cal.getTime());

		customer.setCustomerEmail("service_" + System.currentTimeMillis()
				+ "@oyeseva1.com");
		customer.setCustomerMobile("" + System.currentTimeMillis());
		customer.setCustomerPassword("service_password_"
				+ +System.currentTimeMillis());
		userService.add(customer);

		Customer up = userService.getByCustomerId(customer.getIdcustomer());
		up.setCustomerStatus("-1");
		up.setCustomerEmail("CHANGED@gmail.com");
		userService.update(up);

		Customer up2 = userService.getByCustomerId(up.getIdcustomer());

		System.out.println("listAll: " + userService.listAll());
	}
}
