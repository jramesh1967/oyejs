package com.oyeseva.backoffice.rest.controller;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oyeseva.business.service.CustomerService;
import com.oyeseva.entity.generated.Customer;

@RestController
@RequestMapping("/customers")
public class OyesevaBOCustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Customer> login(
			@RequestBody Customer customer) {
		System.out.println("LOGIN");
		ResponseEntity<Customer> responseEntity = new ResponseEntity<Customer>(
				(Customer) customerService.doLogin(customer), HttpStatus.OK);
		System.out.println("login 1");
		return responseEntity;
	}

	// create/edit BO Customer
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Customer> manageCustomer(
			@RequestBody Customer customer) throws Exception {

		if (customer == null || customerService.getByCustomerId(customer
				.getIdcustomer()) == null) {
			System.out.println("NEW CUSTOMER");
			try {
				/*
				 * if (customerService.isCustomerExist(customer)) {
				 * ResponseEntity<String> responseEntity = new
				 * ResponseEntity<String>( "Customer already exists!",
				 * HttpStatus.CONFLICT); return responseEntity; }
				 */
				// Create the Customer
				Customer new_customer = new Customer();
				new_customer.setUuid(UUID.randomUUID().toString());
				new_customer.setCustomerStatus("-1");
				new_customer.setRegistrationVerificationCode(UUID.randomUUID()
						.toString());

				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DATE, 7); // expiry after 7 days from the date
											// of
											// registration
				new_customer.setRegistrationVerificationCodeExpiresBy(cal
						.getTime());
				new_customer.setCustomerEmail(customer.getCustomerEmail());

				// Mobile is compulsory!
				new_customer.setCustomerMobile(customer.getCustomerMobile());

				new_customer
						.setCustomerPassword(customer.getCustomerPassword());
				new_customer.setCustomerChangeLog("Added new Customer. ");
				customerService.add(new_customer);
				return new ResponseEntity<Customer>(new_customer, HttpStatus.OK);

			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		} else {
			
			System.out.println("EDIT CUSTOMER");
			try {

				if (!customerService.isCustomerExist(customer)) {
					return null;
				}

				// Get the Customer
				Customer cust = customerService.getByCustomerId(customer
						.getIdcustomer());

				// modify Customer
				cust.setUuid(customer.getUuid());
				cust.setCustomerStatus(customer.getCustomerStatus());
				cust.setLastLoggedIn(customer.getLastLoggedIn());
				cust.setPasswordChangeVerificationCode(customer
						.getPasswordChangeVerificationCode());
				cust.setPasswordChangeVerificationCodeExpiresBy(customer
						.getPasswordChangeVerificationCodeExpiresBy());

				// Modify Customer Profile
				// Mobile is compulsory!
				if (customer != null && customer.getCustomerPassword() != null
						&& !customer.getCustomerPassword().equals("")) {
					cust.setCustomerPassword(customer.getCustomerPassword());
				}

				// Mobile is compulsory
				if (customer != null && customer.getCustomerMobile() != null
						&& !customer.getCustomerMobile().equals("")) {
					cust.setCustomerMobile(customer.getCustomerMobile());
				} else {
					return null;
				}
				if (customer != null) {
					cust.setCustomerEmail(customer.getCustomerEmail());
				}
				
				cust.setCustomerChangeLog(customer.getCustomerChangeLog() + "Edited Customer. ");

				// Update
				customerService.update(cust);
				return new ResponseEntity<Customer>(cust, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
	}

	// Load one user
	@RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Customer findCustomer(@PathVariable int id) {
		System.out.println("FIND CUSTOMER");
		Customer customer = customerService.getByCustomerId(id);
		return customer;
	}

	// Delete user
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void deleteCustomer(@PathVariable Long id) {
		System.out.println("DELETE CUSTOMER");
		customerService.deleteByCustomerId(id);
	}

	// Lst all users
	@RequestMapping(method = RequestMethod.GET, value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Customer> listCustomers() {
		System.out.println("LIST CUSTOMERS");
		List<Customer> users = customerService.listAll();
		return users;
	}
}