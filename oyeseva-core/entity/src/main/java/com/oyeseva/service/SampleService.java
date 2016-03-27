package com.oyeseva.service;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oyeseva.entity.mysql.dao.SampleDAO;
import com.oyeseva.entity.mysql.generated.Sample;

@Component
public class SampleService {

	@Autowired
	private SampleDAO sampleDAO;

	@Transactional
	public void add(Sample Sample) {
		sampleDAO.persist(Sample);
	}

	@Transactional
	public void addAll(Collection<Sample> Samples) {
		for (Sample Sample : Samples) {
			sampleDAO.persist(Sample);
		}
	}

	@Transactional
	public List<Sample> listAll() {
		return sampleDAO.findAll();

	}
}