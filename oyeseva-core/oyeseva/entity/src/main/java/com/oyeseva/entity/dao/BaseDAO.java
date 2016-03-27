package com.oyeseva.entity.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class BaseDAO {
	
	@PersistenceContext
	protected EntityManager em;
	
	public void persist(Serializable t) {
		System.out.println("inside persist....");
		em.persist(t);
	}


}
