package com.oyeseva.business.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oyeseva.entity.dao.UserDAO;
import com.oyeseva.entity.dao.UserProfileDAO;
import com.oyeseva.entity.generated.User;
import com.oyeseva.entity.generated.UserProfile;

@Service("userService")
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
	public boolean isUserExist(String username) {
		return userProfileDAO.findByUsername(username) != null;
	}

	@Transactional
	public List<User> listAll() {
		return userDAO.findAll();

	}

	@Transactional
	public UserProfile doLogin(UserProfile userProfile) {
		List<UserProfile> profiles = userProfileDAO
				.findByUsernamePasswordUserActive(userProfile);
		if (profiles.size() == 1) {
			UserProfile up = (UserProfile) profiles.get(0);
			User user = up.getUser();
			user.setLastLoggedIn(new Date());
			userDAO.persist(user);
			return up;
		} else
			return null;

	}

	@Transactional
	public UserProfile getByUsername(String username) {
		return userProfileDAO.findByUsername(username);
	}
	
	@Transactional
	public UserProfile getById(Long id) {
		return userProfileDAO.findById(id);
	}
}