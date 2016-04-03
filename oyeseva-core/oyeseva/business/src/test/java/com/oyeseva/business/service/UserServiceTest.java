package com.oyeseva.business.service;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oyeseva.entity.generated.User;
import com.oyeseva.entity.generated.UserProfile;
import com.oyeseva.business.service.UserService;

public class UserServiceTest {

	// Create Spring application context
	private static ClassPathXmlApplicationContext ctx;

	// Get service from context. (service's dependency (ProductDAO) is autowired
	// in ProductService)
	private static UserService userService;

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
		userService = ctx.getBean(UserService.class);
	}

	@After
	public void tearDown() throws Exception {
		ctx.close();
	}

	@Test
	public final void testUser() {

		User user = new User();
		user.setUuid("test_name2_" + System.currentTimeMillis());

		UserProfile userProfile = new UserProfile();
		userProfile.setPassword("pass");
		userProfile.setUsername("username");
		userProfile.setUser(user);

		userService.add(userProfile);
		System.out.println("listAll: " + userService.listAll());
	}
}
