package com.oyeseva.business.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oyeseva.entity.generated.Customer;
import com.oyeseva.entity.mysql.dao.CustomerDAO;

@Service("customerService")
@Transactional
public class CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	@Transactional
	public void add(Customer customer) {
		try {
			customerDAO.persist(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional
	public void update(Customer customer) {
		try {
			customerDAO.update(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional
	public void addAll(Collection<Customer> customers) {
		for (Customer customer : customers) {
			customerDAO.persist(customer);
		}
	}

	@Transactional
	public boolean isCustomerExist(Customer customer) {
		if (customer.getCustomerEmail() != null
				&& !customer.getCustomerEmail().equals("")
				&& customerDAO.findByEmail(customer.getCustomerEmail()) != null)
			return true;
		if (customer.getCustomerMobile() != null
				&& !customer.getCustomerMobile().equals("")
				&& customerDAO.findByPhone(customer.getCustomerMobile()) != null)
			return true;
		return false;
	}

	@Transactional
	public List<Customer> listAll() {
		return customerDAO.findAll();

	}

	@Transactional
	public Customer doLogin(Customer customer) {
		List<Customer> customers = null;

		customers = customerDAO.findByPhonePasswordActiveCustomer(
				customer.getCustomerMobile(), customer.getCustomerPassword());
		if (customers.size() == 1) {
			Customer up = (Customer) customers.get(0);
			customer.setLastLoggedIn(new Date());
			customerDAO.persist(customer);
			return up;
		}

		customers = customerDAO.findByEmailPasswordActiveCustomer(
				customer.getCustomerEmail(), customer.getCustomerPassword());
		if (customers.size() == 1) {
			Customer up = (Customer) customers.get(0);
			customer.setLastLoggedIn(new Date());
			customerDAO.persist(customer);
			return up;
		}
		return null;
	}

	@Transactional
	public Customer getByEmail(String email) {
		if (email == null || email.trim().equals(""))
			return null;
		List<Customer> customers = customerDAO.findByEmail(email);
		if (customers.size() == 1) {
			return (Customer) customers.get(0);
		} else {
			// multiple customers found
			return null;
		}
	}

	@Transactional
	public Customer getByPhone(String phone) {
		if (phone == null || phone.trim().equals(""))
			return null;
		List<Customer> customers = customerDAO.findByPhone(phone);
		if (customers.size() == 1) {
			return (Customer) customers.get(0);
		} else {
			// multiple customers found
			return null;
		}
	}

	@Transactional
	public Customer getByEmailOrPhone(Customer customer) {
		String email = customer.getCustomerEmail();
		String phone = customer.getCustomerMobile();
		if ((email == null && phone == null)
				|| (email != null && email.trim().equals("") && phone == null)
				|| (phone != null && phone.trim().equals("") && email == null)
				|| (email != null && email.trim().equals("") && phone != null && phone
						.trim().equals(""))) {
			return null;
		}
		List<Customer> customers = customerDAO.findByEmail(email);
		if (customers.size() == 1) {
			return (Customer) customers.get(0);
		}
		customers = customerDAO.findByPhone(phone);
		if (customers.size() == 1) {
			return (Customer) customers.get(0);
		}
		return null;
	}

	@Transactional
	public Customer getByCustomerId(int id) {
		List<Customer> customers = customerDAO.findById(id);
		if (customers == null || customers.size() == 0 || customers.size() > 1) {
			return null;
		} else {
			return customers.get(0);
		}
	}

	@Transactional
	public Customer getByCustomerUUID(String uuid) {
		List<Customer> customers = customerDAO.findByUUID(uuid);
		if (customers == null || customers.size() == 0 || customers.size() > 1) {
			return null;
		} else {
			return customers.get(0);
		}
	}

	@Transactional
	public void deleteByCustomerId(Long id) {
		customerDAO.deleteByCustomerId(id);
	}
}