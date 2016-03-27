package com.oyeseva.backoffice.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oyeseva.business.service.UserService;
import com.oyeseva.entity.mysql.generated.User;
import com.oyeseva.entity.mysql.generated.UserProfile;


@RequestMapping("/users")
@Controller
public class UserController {

	private UserService userService;

	
	@Autowired
	public UserController() {
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> login(
			@RequestBody User user) {
		return null;
	}

	// create user - registration
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> submitUser(@RequestBody User user)
			throws Exception {
		return null;
	}
	
	//Lst all users
	@RequestMapping(method = RequestMethod.GET, value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<UserProfile> listUsers(@PathVariable("sessionId") String dummy) {
		List<UserProfile> users = userService.listAll();
		/*
		if (users != null) {
			Iterator<UserProfile> iter = users.iterator();
			while(iter.hasNext())
			{
				UserProfile profile = iter.next();
				
			}
		}
		return null;
		*/
		return users;
	}
}