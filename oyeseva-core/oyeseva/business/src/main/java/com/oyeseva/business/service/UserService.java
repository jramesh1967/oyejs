package com.oyeseva.business.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oyeseva.entity.generated.User;
import com.oyeseva.entity.generated.UserProfile;
import com.oyeseva.entity.mysql.dao.UserDAO;
import com.oyeseva.entity.mysql.dao.UserProfileDAO;

@Service("userService")
@Transactional
public class UserService {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private UserProfileDAO userProfileDAO;

	@Transactional
	public void add(UserProfile userProfile) {
		try {
			User user = userProfile.getUser();
			userDAO.persist(user);
			userProfileDAO.persist(userProfile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional
	public void update(UserProfile userProfile) {
		try {
			userProfileDAO.update(userProfile);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	public boolean isUserExist(UserProfile userProfile) {
		if (userProfile.getEmail() != null
				&& !userProfile.getEmail().equals("")
				&& userProfileDAO.findByEmail(userProfile.getEmail()) != null)
			return true;
		if (userProfile.getPhone() != null
				&& !userProfile.getPhone().equals("")
				&& userProfileDAO.findByPhone(userProfile.getPhone()) != null)
			return true;
		return false;
	}

	@Transactional
	public List<UserProfile> listAll() {
		return userProfileDAO.findAll();

	}

	@Transactional
	public UserProfile doLogin(UserProfile userProfile) {
		List<UserProfile> profiles = null;

		profiles = userProfileDAO.findByPhonePasswordActiveUser(
				userProfile.getPhone(), userProfile.getPassword());
		if (profiles.size() == 1) {
			UserProfile up = (UserProfile) profiles.get(0);
			User user = up.getUser();
			user.setLastLoggedIn(new Date());
			userDAO.persist(user);
			return up;
		}

		profiles = userProfileDAO.findByEmailPasswordActiveUser(
				userProfile.getEmail(), userProfile.getPassword());
		if (profiles.size() == 1) {
			UserProfile up = (UserProfile) profiles.get(0);
			User user = up.getUser();
			user.setLastLoggedIn(new Date());
			userDAO.persist(user);
			return up;
		}
		return null;
	}

	@Transactional
	public UserProfile getByEmail(String email) {
		if (email == null || email.trim().equals(""))
			return null;
		List<UserProfile> profiles = userProfileDAO.findByEmail(email);
		if (profiles.size() == 1) {
			return (UserProfile) profiles.get(0);
		} else {
			// multiple profiles found
			return null;
		}
	}

	@Transactional
	public UserProfile getByPhone(String phone) {
		if (phone == null || phone.trim().equals(""))
			return null;
		List<UserProfile> profiles = userProfileDAO.findByPhone(phone);
		if (profiles.size() == 1) {
			return (UserProfile) profiles.get(0);
		} else {
			// multiple profiles found
			return null;
		}
	}

	@Transactional
	public UserProfile getByEmailOrPhone(UserProfile userProfile) {
		String email = userProfile.getEmail();
		String phone = userProfile.getEmail();
		if ((email == null && phone == null)
				|| (email != null && email.trim().equals("") && phone == null)
				|| (phone != null && phone.trim().equals("") && email == null)
				|| (email != null && email.trim().equals("") && phone != null && phone
						.trim().equals(""))) {
			return null;
		}
		List<UserProfile> profiles = userProfileDAO.findByEmail(email);
		if (profiles.size() == 1) {
			return (UserProfile) profiles.get(0);
		}
		profiles = userProfileDAO.findByPhone(phone);
		if (profiles.size() == 1) {
			return (UserProfile) profiles.get(0);
		}
		return null;
	}

	@Transactional
	public UserProfile getByUserId(Long id) {
		List<UserProfile> profiles = userProfileDAO.findByUserId(id);
		if (profiles == null || profiles.size() == 0 || profiles.size() > 1) {
			return null;
		} else {
			return profiles.get(0);
		}
	}

	@Transactional
	public void deleteByUserId(Long id) {
		userProfileDAO.deleteByUserId(id);
	}

	@Transactional
	public UserProfile getByProfileId(Long id) {
		List<UserProfile> profiles = userProfileDAO.findById(id);
		if (profiles == null || profiles.size() == 0 || profiles.size() > 1) {
			return null;
		} else {
			return profiles.get(0);
		}
	}
}