package com.oyeseva.entity.generated;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the user_profile database table.
 * 
 */
@Entity
@Table(name = "user_profile")
@NamedQuery(name = "UserProfile.findAll", query = "SELECT u FROM UserProfile u")
public class UserProfile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(length = 100)
	private String email;

	@Column(name = "new_password", length = 255)
	private String newPassword;

	@Column(nullable = false, length = 45)
	private String password;

	@Column(nullable = false, length = 45)
	private String phone;

	// uni-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public UserProfile() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNewPassword() {
		return this.newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}