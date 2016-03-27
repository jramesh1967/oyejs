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

import com.oyeseva.entity.generated.User;
import com.oyeseva.entity.generated.UserProfile;
import com.oyeseva.service.UserService;

public class UserTest {

	private static ClassPathXmlApplicationContext ctx;
	private static UserService userService;

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
		userService = ctx.getBean(UserService.class);
	}

	@After
	public void tearDown() throws Exception {
		ctx.close();
	}

	@Test
	public final void testSample() {
		//Create the User
		User user = new User();
		user.setUuid(UUID.randomUUID().toString());

		//Create User Profile
		UserProfile userProfile = new UserProfile();
		userProfile.setUser(user);
		userProfile.setUsername("username_" + + System.currentTimeMillis());
		userProfile.setPassword("password_" + + System.currentTimeMillis());
		userService.add(userProfile);
		
		List<UserProfile> profiles = userService.listAll();
		Iterator<UserProfile> iter = profiles.iterator();
		while(iter.hasNext())
		{
			UserProfile pf = (UserProfile)iter.next();
			System.out.println("username = " + pf.getUsername());
			System.out.println("password = " + pf.getPassword());
			User u = pf.getUser();
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
