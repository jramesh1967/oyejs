package com.oyeseva.entity.generated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the backoffice_user database table.
 * 
 */
@Entity
@Table(name="backoffice_user")
@NamedQuery(name="BackofficeUser.findAll", query="SELECT b FROM BackofficeUser b")
public class BackofficeUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idbackoffice_user", unique=true, nullable=false)
	private int idbackofficeUser;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="backoffice_user_date_created")
	private Date backofficeUserDateCreated;

	@Column(name="backoffice_user_name", length=45)
	private String backofficeUserName;

	@Column(name="backoffice_user_password", length=45)
	private String backofficeUserPassword;

	@Column(name="backoffice_user_role", length=45)
	private String backofficeUserRole;

	@Column(name="backoffice_user_status", length=1)
	private String backofficeUserStatus;

	//bi-directional many-to-one association to BackofficePasswordRecovery
	@OneToMany(mappedBy="backofficeUser")
	private List<BackofficePasswordRecovery> backofficePasswordRecoveries;

	public BackofficeUser() {
	}

	public int getIdbackofficeUser() {
		return this.idbackofficeUser;
	}

	public void setIdbackofficeUser(int idbackofficeUser) {
		this.idbackofficeUser = idbackofficeUser;
	}

	public Date getBackofficeUserDateCreated() {
		return this.backofficeUserDateCreated;
	}

	public void setBackofficeUserDateCreated(Date backofficeUserDateCreated) {
		this.backofficeUserDateCreated = backofficeUserDateCreated;
	}

	public String getBackofficeUserName() {
		return this.backofficeUserName;
	}

	public void setBackofficeUserName(String backofficeUserName) {
		this.backofficeUserName = backofficeUserName;
	}

	public String getBackofficeUserPassword() {
		return this.backofficeUserPassword;
	}

	public void setBackofficeUserPassword(String backofficeUserPassword) {
		this.backofficeUserPassword = backofficeUserPassword;
	}

	public String getBackofficeUserRole() {
		return this.backofficeUserRole;
	}

	public void setBackofficeUserRole(String backofficeUserRole) {
		this.backofficeUserRole = backofficeUserRole;
	}

	public String getBackofficeUserStatus() {
		return this.backofficeUserStatus;
	}

	public void setBackofficeUserStatus(String backofficeUserStatus) {
		this.backofficeUserStatus = backofficeUserStatus;
	}

	public List<BackofficePasswordRecovery> getBackofficePasswordRecoveries() {
		return this.backofficePasswordRecoveries;
	}

	public void setBackofficePasswordRecoveries(List<BackofficePasswordRecovery> backofficePasswordRecoveries) {
		this.backofficePasswordRecoveries = backofficePasswordRecoveries;
	}

	public BackofficePasswordRecovery addBackofficePasswordRecovery(BackofficePasswordRecovery backofficePasswordRecovery) {
		getBackofficePasswordRecoveries().add(backofficePasswordRecovery);
		backofficePasswordRecovery.setBackofficeUser(this);

		return backofficePasswordRecovery;
	}

	public BackofficePasswordRecovery removeBackofficePasswordRecovery(BackofficePasswordRecovery backofficePasswordRecovery) {
		getBackofficePasswordRecoveries().remove(backofficePasswordRecovery);
		backofficePasswordRecovery.setBackofficeUser(null);

		return backofficePasswordRecovery;
	}

}