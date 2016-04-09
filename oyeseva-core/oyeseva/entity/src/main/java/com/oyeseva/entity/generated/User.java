package com.oyeseva.entity.generated;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name = "user")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(name = "is_active")
	private int isActive;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_logged_in")
	private Date lastLoggedIn;

	@Column(name = "password_change_verification_code", length = 255)
	private String passwordChangeVerificationCode;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "password_change_verification_code_expires_by")
	private Date passwordChangeVerificationCodeExpiresBy;

	@Column(name = "registration_verification_code", length = 255)
	private String registrationVerificationCode;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "registration_verification_code_expires_by")
	private Date registrationVerificationCodeExpiresBy;

	@Column(nullable = false, length = 45)
	private String uuid;

	public User() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getIsActive() {
		return this.isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
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

	public void setPasswordChangeVerificationCode(
			String passwordChangeVerificationCode) {
		this.passwordChangeVerificationCode = passwordChangeVerificationCode;
	}

	public Date getPasswordChangeVerificationCodeExpiresBy() {
		return this.passwordChangeVerificationCodeExpiresBy;
	}

	public void setPasswordChangeVerificationCodeExpiresBy(
			Date passwordChangeVerificationCodeExpiresBy) {
		this.passwordChangeVerificationCodeExpiresBy = passwordChangeVerificationCodeExpiresBy;
	}

	public String getRegistrationVerificationCode() {
		return this.registrationVerificationCode;
	}

	public void setRegistrationVerificationCode(
			String registrationVerificationCode) {
		this.registrationVerificationCode = registrationVerificationCode;
	}

	public Date getRegistrationVerificationCodeExpiresBy() {
		return this.registrationVerificationCodeExpiresBy;
	}

	public void setRegistrationVerificationCodeExpiresBy(
			Date registrationVerificationCodeExpiresBy) {
		this.registrationVerificationCodeExpiresBy = registrationVerificationCodeExpiresBy;
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

}