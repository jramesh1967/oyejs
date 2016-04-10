package com.oyeseva.entity.mysql.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.oyeseva.entity.generated.Customer;

@Component
public class CustomerDAO extends BaseDAO {

	public CustomerDAO() {
	}

	public List<Customer> findAll() {
		return (List<Customer>) em.createQuery("SELECT c FROM Customer c")
				.getResultList();
	}

	public List<Customer> findById(int id) {
		return (List<Customer>) em.createQuery(
				"SELECT c FROM Customer c where c.idcustomer = " + id)
				.getResultList();
	}

	public List<Customer> findByUUID(String uuid) {
		return (List<Customer>) em.createQuery(
				"SELECT c FROM Customer c where c.uuid = '" + uuid + "'")
				.getResultList();
	}

	public List<Customer> findByEmail(String customerEmail) {
		return (List<Customer>) em.createQuery(
				"SELECT c FROM Customer c where c.customerEmail = '"
						+ customerEmail + "'").getResultList();
	}

	public List<Customer> findByPhone(String customerMobile) {
		return (List<Customer>) em.createQuery(
				"SELECT c FROM Customer c where c.customerMobile = '"
						+ customerMobile + "'").getResultList();
	}

	public List<Customer> findByPhonePasswordActiveCustomer(
			String customerMobile, String customerPassword) {
		return (List<Customer>) em.createQuery(
				"SELECT c FROM Customer c where c.customerMobile = '"
						+ customerMobile + "' and c.customerPassword = '"
						+ customerPassword + "' and customerStatus = '1'")
				.getResultList();
	}

	public List<Customer> findByEmailPasswordActiveCustomer(
			String customerEmail, String customerPassword) {
		return (List<Customer>) em.createQuery(
				"SELECT c FROM Customer c where c.customerEmail = '"
						+ customerEmail + "' and c.customerPassword = '"
						+ customerPassword + "' and customerStatus = '1'")
				.getResultList();
	}

	public void deleteByCustomerId(Long id) {
		// TODO Auto-generated method stub

	}
}
