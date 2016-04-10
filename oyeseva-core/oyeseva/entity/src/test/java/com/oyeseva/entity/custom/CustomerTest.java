package com.oyeseva.entity.custom;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oyeseva.entity.generated.Customer;
import com.oyeseva.entity.mysql.dao.CustomerDAO;

public class CustomerTest {

	private static ClassPathXmlApplicationContext ctx;
	private static CustomerDAO customerDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		// Create Spring application context
		ctx = new ClassPathXmlApplicationContext("classpath:/spring.xml");

		// Get service from context.
		customerDAO = ctx.getBean(CustomerDAO.class);
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
		String customer_status = "-1";// New
		customer.setCustomerStatus(customer_status);
		customer.setRegistrationVerificationCode(UUID.randomUUID().toString());
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 7); // expiry after 7 days from the date of
									// registration
		customer.setRegistrationVerificationCodeExpiresBy(cal.getTime());
		// Create Customer Profile
		customer.setCustomerChangeLog("New Customer created...");
		customer.setCustomerMobile("" + System.currentTimeMillis());
		customer.setCustomerEmail("entity_" + System.currentTimeMillis()
				+ "@oyeseva.com");
		customer.setCustomerPassword("entity_password_"
				+ +System.currentTimeMillis());
		customerDAO.persist(customer);

		List<Customer> customers = customerDAO.findAll();

		/*
		 * Iterator<CustomerProfile> iter = profiles.iterator();
		 * while(iter.hasNext()) { CustomerProfile pf =
		 * (CustomerProfile)iter.next(); System.out.println("Customername = " +
		 * pf.getCustomername()); System.out.println("password = " +
		 * pf.getPassword()); Customer u = pf.getCustomer();
		 * System.out.println("Customer u exists :: " +
		 * CustomerProfileDAO.findByCustomername("'Customername'") != null);
		 * 
		 * System.out.println("##### Customer u getbyid :: " +
		 * CustomerProfileDAO.findById(u.getId())); System.out.println("uuid = "
		 * + u.getUuid()); }
		 */

	}

	/*
	 * @Test public final void testGetId() { fail("Not yet implemented"); //
	 * TODO }
	 * 
	 * @Test public final void testSetId() { fail("Not yet implemented"); //
	 * TODO }
	 * 
	 * @Test public final void testGetUuid() { fail("Not yet implemented"); //
	 * TODO }
	 * 
	 * @Test public final void testSetUuid() { fail("Not yet implemented"); //
	 * TODO }
	 * 
	 * @Test public final void testGetCustomerProfiles() {
	 * fail("Not yet implemented"); // TODO }
	 * 
	 * @Test public final void testSetCustomerProfiles() {
	 * fail("Not yet implemented"); // TODO }
	 * 
	 * @Test public final void testAddCustomerProfile() {
	 * fail("Not yet implemented"); // TODO }
	 * 
	 * @Test public final void testRemoveCustomerProfile() {
	 * fail("Not yet implemented"); // TODO }
	 */
}
