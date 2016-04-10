package com.oyeseva.entity.generated;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the backoffice_password_recovery database table.
 * 
 */
@Entity
@Table(name="backoffice_password_recovery")
@NamedQuery(name="BackofficePasswordRecovery.findAll", query="SELECT b FROM BackofficePasswordRecovery b")
public class BackofficePasswordRecovery implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BackofficePasswordRecoveryPK id;

	//bi-directional many-to-one association to BackofficeUser
	@ManyToOne
	@JoinColumn(name="backoffice_user_idbackoffice_user", nullable=false, insertable=false, updatable=false)
	private BackofficeUser backofficeUser;

	public BackofficePasswordRecovery() {
	}

	public BackofficePasswordRecoveryPK getId() {
		return this.id;
	}

	public void setId(BackofficePasswordRecoveryPK id) {
		this.id = id;
	}

	public BackofficeUser getBackofficeUser() {
		return this.backofficeUser;
	}

	public void setBackofficeUser(BackofficeUser backofficeUser) {
		this.backofficeUser = backofficeUser;
	}

}