package com.oyeseva.business.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.oyeseva.entity.mysql.dao.UserDAO;
import com.oyeseva.entity.mysql.dao.UserProfileDAO;
import com.oyeseva.entity.mysql.generated.User;
import com.oyeseva.entity.mysql.generated.UserProfile;

@Component
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
	public List<UserProfile> listAll() {
		return userProfileDAO.findAll();
	}
}