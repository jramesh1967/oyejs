package com.oyeseva.entity.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.oyeseva.entity.generated.UserProfile;

@Component
public class UserProfileDAO extends BaseDAO {

	public UserProfileDAO() {
	}

	public List<UserProfile> findAll() {
		return (List<UserProfile>) em.createQuery(
				"SELECT up FROM UserProfile up").getResultList();
	}
	
	public UserProfile findById(long id) {
		return (UserProfile) em.createQuery(
				"SELECT up FROM UserProfile up, User u where up.user = u.id and u.id = " + id)
				.getSingleResult();
	}
	

	public UserProfile findByUsername(String email) {
		return (UserProfile) em.createQuery(
				"SELECT up FROM UserProfile up where up.username = " + email)
				.getSingleResult();
	}

	public List<UserProfile> findByUsernamePasswordUserActive(
			UserProfile userProfile) {
		return (List<UserProfile>) em.createQuery(
				"SELECT up FROM UserProfile up where up.username = "
						+ userProfile.getUsername() + " and up.password = "
						+ userProfile.getPassword() + " and is_active = 1")
				.getResultList();
	}
}
