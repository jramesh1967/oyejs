package com.oyeseva.business.service;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oyeseva.entity.dao.UserDAO;
import com.oyeseva.entity.dao.UserProfileDAO;
import com.oyeseva.entity.generated.User;
import com.oyeseva.entity.generated.UserProfile;

@Service ("userService")
public class UserService {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private UserProfileDAO userProfileDAO;

	@Transactional
	public void add(UserProfile userProfile) {
		User user = userProfile.getUser();
		userDAO.persist(user);
		userProfileDAO.persist(userProfile);
	}

	@Transactional
	public void addAll(Collection<UserProfile> userProfiles) {
		for (UserProfile userProfile : userProfiles) {
			User user = userProfile.getUser();
			userDAO.persist(user);
			userProfileDAO.persist(userProfile);
		}
	}

	@Transactional
	public List<User> listAll() {
		return userDAO.findAll();

	}
}