package com.oyeseva.entity.generated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the customer database table.
 * 
 */
@Entity
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idcustomer;

	@Lob
	@Column(name="customer_change_log")
	private String customerChangeLog;

	@Column(name="customer_email")
	private String customerEmail;

	@Column(name="customer_mobile")
	private String customerMobile;

	@Column(name="customer_password")
	private String customerPassword;

	@Column(name="customer_status")
	private String customerStatus;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_logged_in")
	private Date lastLoggedIn;

	@Column(name="password_change_verification_code")
	private String passwordChangeVerificationCode;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="password_change_verification_code_expires_by")
	private Date passwordChangeVerificationCodeExpiresBy;

	@Column(name="registration_verification_code")
	private String registrationVerificationCode;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="registration_verification_code_expires_by")
	private Date registrationVerificationCodeExpiresBy;

	private String uuid;

	public Customer() {
	}

	public int getIdcustomer() {
		return this.idcustomer;
	}

	public void setIdcustomer(int idcustomer) {
		this.idcustomer = idcustomer;
	}

	public String getCustomerChangeLog() {
		return this.customerChangeLog;
	}

	public void setCustomerChangeLog(String customerChangeLog) {
		this.customerChangeLog = customerChangeLog;
	}

	public String getCustomerEmail() {
		return this.customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerMobile() {
		return this.customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getCustomerPassword() {
		return this.customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getCustomerStatus() {
		return this.customerStatus;
	}

	public void setCustomerStatus(String customerStatus) {
		this.customerStatus = customerStatus;
	}

	public Date getLastLoggedIn() {
		return this.lastLoggedIn;
	}

	public void setLastLoggedIn(Date lastLoggedIn) {
		this.lastLoggedIn = lastLoggedIn;
	}

	public String getPasswordChangeVerificationCode() {
		return this.passwordChangeVerificationCode;
	}

	public void setPasswordChangeVerificationCode(String passwordChangeVerificationCode) {
		this.passwordChangeVerificationCode = passwordChangeVerificationCode;
	}

	public Date getPasswordChangeVerificationCodeExpiresBy() {
		return this.passwordChangeVerificationCodeExpiresBy;
	}

	public void setPasswordChangeVerificationCodeExpiresBy(Date passwordChangeVerificationCodeExpiresBy) {
		this.passwordChangeVerificationCodeExpiresBy = passwordChangeVerificationCodeExpiresBy;
	}

	public String getRegistrationVerificationCode() {
		return this.registrationVerificationCode;
	}

	public void setRegistrationVerificationCode(String registrationVerificationCode) {
		this.registrationVerificationCode = registrationVerificationCode;
	}

	public Date getRegistrationVerificationCodeExpiresBy() {
		return this.registrationVerificationCodeExpiresBy;
	}

	public void setRegistrationVerificationCodeExpiresBy(Date registrationVerificationCodeExpiresBy) {
		this.registrationVerificationCodeExpiresBy = registrationVerificationCodeExpiresBy;
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

}