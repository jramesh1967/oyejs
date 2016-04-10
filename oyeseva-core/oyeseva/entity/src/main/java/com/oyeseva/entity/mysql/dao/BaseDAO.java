package com.oyeseva.entity.mysql.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public abstract class BaseDAO {

	@PersistenceContext
	protected EntityManager em;

	@Transactional
	public void persist(Serializable t) {
		em.persist(t);
		try {
			em.flush();
		} catch (Exception tre) {
			tre.printStackTrace();
			// ignore
		}
	}

	@Transactional
	public void update(Serializable t) {
		em.merge(t);
	}
}
