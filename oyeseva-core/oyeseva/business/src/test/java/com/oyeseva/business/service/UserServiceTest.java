package com.oyeseva.business.service;

import java.util.Calendar;
import java.util.UUID;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oyeseva.entity.generated.User;
import com.oyeseva.entity.generated.UserProfile;

public class UserServiceTest {

	// Create Spring application context
	private static ClassPathXmlApplicationContext ctx;

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

		// Create the User
		User user = new User();
		user.setUuid(UUID.randomUUID().toString());
		int is_active = 1;
		user.setIsActive(is_active);
		user.setRegistrationVerificationCode(UUID.randomUUID().toString());
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 7); // expiry after 7 days from the date of
									// registration
		user.setRegistrationVerificationCodeExpiresBy(cal.getTime());
		// Create User Profile
		UserProfile userProfile = new UserProfile();
		userProfile.setUser(user);
		userProfile.setEmail("service_" + System.currentTimeMillis()
				+ "@oyeseva1.com");
		userProfile.setPhone("" + System.currentTimeMillis());
		userProfile.setPassword("service_password_"
				+ +System.currentTimeMillis());
		userProfile.setUser(user);
		userService.add(userProfile);

		UserProfile up = userService.getByProfileId(userProfile.getId());
		User u = up.getUser();
		u.setIsActive(0);
		up.setUser(u);
		up.setEmail("CHANGED@gmail.com");
		userService.update(up);

		UserProfile up2 = userService.getByProfileId(up.getId());
		User u2 = up2.getUser();

		// ??System.out.println("##### IsActive after edit = " +
		// u2.getIsActive());

		userService.getByUserId(user.getId());

		System.out.println("listAll: " + userService.listAll());
	}
}
