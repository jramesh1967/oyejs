package com.oyeseva.entity.mysql.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.oyeseva.entity.generated.User;

@Component
public class UserDAO extends BaseDAO {

	public UserDAO() {
	}

	public List<User> findAll() {
		return (List<User>) em.createQuery("SELECT u FROM User u")
				.getResultList();
	}
}
