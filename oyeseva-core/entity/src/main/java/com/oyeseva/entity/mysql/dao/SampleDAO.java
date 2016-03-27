package com.oyeseva.entity.mysql.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.oyeseva.entity.mysql.generated.Sample;

@Component
public class SampleDAO extends BaseDAO {

	public SampleDAO() {
	}

	public List<Sample> findAll() {
		return (List<Sample>) em.createQuery("SELECT s FROM Sample s")
				.getResultList();
	}
}
