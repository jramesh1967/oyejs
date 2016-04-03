package com.oyeseva.customer.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oyeseva.business.service.UserService;
import com.oyeseva.entity.generated.User;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	//public UserController(){}
	
	/*
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	*/

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> login(@RequestBody User user) {
		return null;
	}

	// create user - registration
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> submitUser(@RequestBody User user)
			throws Exception {
		return null;
	}

	// Lst all users
	@RequestMapping(method = RequestMethod.GET, value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<User> listUsers() {
		List<User> users = userService.listAll();
		System.out.println("user list size = " + users.size());
		/*
		 * if (users != null) { Iterator<UserProfile> iter = users.iterator();
		 * while(iter.hasNext()) { UserProfile profile = iter.next();
		 * 
		 * } } return null;
		 */
		return users;
	}
}