package com.oyeseva.entity.custom;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oyeseva.entity.dao.UserDAO;
import com.oyeseva.entity.dao.UserProfileDAO;
import com.oyeseva.entity.generated.User;
import com.oyeseva.entity.generated.UserProfile;
//

public class UserTest {

	private static ClassPathXmlApplicationContext ctx;
	private static UserDAO userDAO;
	private static UserProfileDAO userProfileDAO;

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
		userDAO = ctx.getBean(UserDAO.class);
		userProfileDAO = ctx.getBean(UserProfileDAO.class);
	}

	@After
	public void tearDown() throws Exception {
		ctx.close();
	}

	@Test
	public final void testUser() {
		//Create the User
		User user = new User();
		user.setUuid(UUID.randomUUID().toString());
		int is_active = 0;
		user.setIsActive(is_active);

		//Create User Profile
		UserProfile userProfile = new UserProfile();
		userProfile.setUser(user);
		userProfile.setUsername("username_" + + System.currentTimeMillis());
		userProfile.setPassword("password_" + + System.currentTimeMillis());
		userDAO.persist(userProfile);
		
		List<UserProfile> profiles = userProfileDAO.findAll();
		Iterator<UserProfile> iter = profiles.iterator();
		while(iter.hasNext())
		{
			UserProfile pf = (UserProfile)iter.next();
			System.out.println("username = " + pf.getUsername());
			System.out.println("password = " + pf.getPassword());
			User u = pf.getUser();
			System.out.println("User u exists :: " + userProfileDAO.findByUsername("'username'") != null);
			
			System.out.println("##### User u getbyid :: " + userProfileDAO.findById(u.getId()));
			System.out.println("uuid = " + u.getUuid());
		}
		
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
	 * @Test public final void testGetUserProfiles() {
	 * fail("Not yet implemented"); // TODO }
	 * 
	 * @Test public final void testSetUserProfiles() {
	 * fail("Not yet implemented"); // TODO }
	 * 
	 * @Test public final void testAddUserProfile() {
	 * fail("Not yet implemented"); // TODO }
	 * 
	 * @Test public final void testRemoveUserProfile() {
	 * fail("Not yet implemented"); // TODO }
	 */
}
