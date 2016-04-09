package com.oyeseva.entity.mysql.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.oyeseva.entity.generated.User;
import com.oyeseva.entity.generated.UserProfile;

@Component
public class UserProfileDAO extends BaseDAO {

	public UserProfileDAO() {
	}

	public List<UserProfile> findById(Long id) {
		return (List<UserProfile>) em.createQuery(
				"SELECT up FROM UserProfile up where up.id = " + id)
				.getResultList();
	}

	public List<UserProfile> findAll() {
		return (List<UserProfile>) em.createQuery(
				"SELECT up FROM UserProfile up").getResultList();
	}

	public List<UserProfile> findByUser(User u) {
		return (List<UserProfile>) em.createQuery(
				"SELECT up FROM UserProfile up where up.user = " + u)
				.getResultList();
	}

	public List<UserProfile> findByUserId(Long id) {
		return (List<UserProfile>) em.createQuery(
				"SELECT up FROM UserProfile up where up.user.id = " + id)
				.getResultList();
	}

	public void deleteByUserId(Long id) {
		List<UserProfile> profiles = findByUserId(id);
		UserProfile profile = (UserProfile) profiles.get(0);
		User user = profile.getUser();
		user.setIsActive(0);
		this.persist(user);
		profile.setUser(user);
		this.persist(profile);
		em.createQuery("UPDATE up FROM UserProfile up where up.user.id = " + id);
	}

	public List<UserProfile> findByPhone(String phone) {
		return (List<UserProfile>) em.createQuery(
				"SELECT up FROM UserProfile up where up.phone = '" + phone
						+ "'").getResultList();
	}

	public List<UserProfile> findByEmail(String email) {
		return (List<UserProfile>) em.createQuery(
				"SELECT up FROM UserProfile up where up.email = '" + email
						+ "'").getResultList();
	}

	public List<UserProfile> findByPhonePasswordActiveUser(String phone,
			String password) {
		return (List<UserProfile>) em.createQuery(
				"SELECT up FROM UserProfile up, User u where u.id = up.userId and up.phone = '"
						+ phone + "' and up.isActive = 1").getResultList();
	}

	public List<UserProfile> findByEmailPasswordActiveUser(String email,
			String password) {
		return (List<UserProfile>) em.createQuery(
				"SELECT up FROM UserProfile up, User u where u.id = up.userId and up.email = '"
						+ email + "' and up.isActive = 1").getResultList();
	}
}
