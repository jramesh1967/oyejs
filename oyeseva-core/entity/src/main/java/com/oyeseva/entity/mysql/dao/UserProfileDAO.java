package com.oyeseva.entity.mysql.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.oyeseva.entity.mysql.generated.User;
import com.oyeseva.entity.mysql.generated.UserProfile;

@Component
public class UserProfileDAO extends BaseDAO {

	public UserProfileDAO() {
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
}
