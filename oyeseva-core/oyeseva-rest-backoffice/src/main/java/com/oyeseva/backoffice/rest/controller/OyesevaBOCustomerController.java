package com.oyeseva.backoffice.rest.controller;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oyeseva.business.service.UserService;
import com.oyeseva.entity.generated.User;
import com.oyeseva.entity.generated.UserProfile;

@RestController
@RequestMapping("/users")
public class OyesevaBOCustomerController {

	@Autowired
	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<UserProfile> login(
			@RequestBody UserProfile userProfile) {
		System.out.println("LOGIN");
		ResponseEntity<UserProfile> responseEntity = new ResponseEntity<UserProfile>(
				(UserProfile) userService.doLogin(userProfile), HttpStatus.OK);
		System.out.println("login 1");
		return responseEntity;
	}

	// create/edit BO Customer
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<UserProfile> manageUser(
			@RequestBody UserProfile userProfile) throws Exception {

		if (userProfile == null || userProfile.getUser() == null) {
			System.out.println("NEW USER");
			try {
				/*
				 * if (userService.isUserExist(userProfile)) {
				 * ResponseEntity<String> responseEntity = new
				 * ResponseEntity<String>( "User already exists!",
				 * HttpStatus.CONFLICT); return responseEntity; }
				 */
				// Create the User
				User new_user = new User();
				new_user.setUuid(UUID.randomUUID().toString());
				new_user.setIsActive(0);
				new_user.setRegistrationVerificationCode(UUID.randomUUID()
						.toString());

				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DATE, 7); // expiry after 7 days from the date
											// of
											// registration
				new_user.setRegistrationVerificationCodeExpiresBy(cal.getTime());

				// Create User Profile
				UserProfile new_user_profile = new UserProfile();
				new_user_profile.setEmail(userProfile.getEmail());
				new_user_profile.setPhone(userProfile.getPhone());
				new_user_profile.setPassword(userProfile.getPassword());

				new_user_profile.setUser(new_user);
				userService.add(new_user_profile);
				return new ResponseEntity<UserProfile>(new_user_profile,
						HttpStatus.OK);

			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		} else {
			try {

				if (!userService.isUserExist(userProfile)) {
					return null;
				}

				// Get the User
				UserProfile profile = userService.getByProfileId(userProfile
						.getId());

				User user = profile.getUser();

				// modify User
				user.setUuid(user.getUuid());
				user.setIsActive(user.getIsActive());
				user.setLastLoggedIn(user.getLastLoggedIn());
				user.setPasswordChangeVerificationCode(user
						.getPasswordChangeVerificationCode());
				user.setPasswordChangeVerificationCodeExpiresBy(user
						.getPasswordChangeVerificationCodeExpiresBy());

				// Modify User Profile
				if (userProfile != null && userProfile.getPassword() != null
						&& !userProfile.getPassword().equals("")) {
					profile.setPassword(userProfile.getPassword());
				}
				if (userProfile != null && userProfile.getPhone() != null
						&& !userProfile.getPhone().equals("")) {
					profile.setPhone(userProfile.getPhone());
				}
				if (userProfile != null) {
					profile.setEmail(userProfile.getEmail());
				}
				profile.setUser(user);

				userService.update(profile);
				return new ResponseEntity<UserProfile>(profile, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
	}

	// Load one user
	@RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public UserProfile findUser(@PathVariable Long id) {
		System.out.println("FIND USER");
		UserProfile userProfile = userService.getByUserId(id);
		return userProfile;
	}

	// Delete user
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void deleteUser(@PathVariable Long id) {
		System.out.println("DELETE USER");
		userService.deleteByUserId(id);
	}

	// Lst all users
	@RequestMapping(method = RequestMethod.GET, value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<UserProfile> listUsers() {
		System.out.println("LIST USERS");
		List<UserProfile> users = userService.listAll();
		return users;
	}
}