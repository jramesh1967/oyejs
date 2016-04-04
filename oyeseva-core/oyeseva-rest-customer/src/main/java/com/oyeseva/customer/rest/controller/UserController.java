package com.oyeseva.customer.rest.controller;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oyeseva.business.service.UserService;
import com.oyeseva.entity.generated.User;
import com.oyeseva.entity.generated.UserProfile;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<UserProfile> login(
			@RequestBody UserProfile userProfile) {
		ResponseEntity<UserProfile> responseEntity = new ResponseEntity<UserProfile>(
				(UserProfile) userService.doLogin(userProfile), HttpStatus.OK);
		return responseEntity;
	}

	// create user - registration
	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> createUser(
			@RequestBody UserProfile userProfile) throws Exception {

		System.out.println("NEW USER");
		try {
			if (userService.isUserExist(userProfile.getUsername())) {
				ResponseEntity<String> responseEntity = new ResponseEntity<String>(
						"Username already exists!", HttpStatus.CONFLICT);
				return responseEntity;
			}

			// Create the User
			User new_user = new User();
			new_user.setUuid(UUID.randomUUID().toString());
			new_user.setIsActive(0);
			new_user.setRegistrationVerificationCode(UUID.randomUUID()
					.toString());

			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, 7); // expiry after 7 days from the date of
										// registration
			new_user.setRegistrationVerificationCodeExpiresBy(cal.getTime());

			// Create User Profile
			UserProfile new_user_profile = new UserProfile();
			new_user_profile.setUser(new_user);
			new_user_profile.setUsername(userProfile.getUsername());
			new_user_profile.setPassword(userProfile.getPassword());
			userService.add(new_user_profile);
			return new ResponseEntity<String>("Successfully registered user!",
					HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Error while registering user!",
					HttpStatus.CREATED);
		}
	}

	// create user - registration
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<UserProfile> updateUser(
			@RequestBody UserProfile userProfile) throws Exception {

		System.out.println("UPDATE USER");
		try {
			if (!userService.isUserExist(userProfile.getUsername())) {
				return null;
			}

			// Get the User
			UserProfile profile = userService.getByUsername(userProfile
					.getUsername());
			User user = profile.getUser();

			user.setIsActive(user.getIsActive());

			// Modify User Profile
			UserProfile changed_user_profile = new UserProfile();

			if (userProfile.getPassword() != null) {
				changed_user_profile.setPassword(userProfile.getPassword());
			}
			changed_user_profile.setUser(user);
			userService.add(changed_user_profile);
			return new ResponseEntity<UserProfile>(changed_user_profile,
					HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Lst all users
	@RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public UserProfile findUser(@PathVariable Long id) {
		System.out.println("**** id ***** = " + id);
		UserProfile userProfile = userService.getById(id);
		System.out.println("user list size = " + userProfile.getUsername());
		return userProfile;
	}

	// Lst all users
	@RequestMapping(method = RequestMethod.GET, value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<User> listUsers() {
		List<User> users = userService.listAll();
		System.out.println("user list size = " + users.size());
		return users;
	}
}