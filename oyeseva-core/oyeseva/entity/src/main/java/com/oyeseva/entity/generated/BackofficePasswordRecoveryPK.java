package com.oyeseva.entity.generated;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the backoffice_password_recovery database table.
 * 
 */
@Embeddable
public class BackofficePasswordRecoveryPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="idbackoffice_password_recovery", unique=true, nullable=false)
	private int idbackofficePasswordRecovery;

	@Column(name="backoffice_user_idbackoffice_user", insertable=false, updatable=false, unique=true, nullable=false)
	private int backofficeUserIdbackofficeUser;

	public BackofficePasswordRecoveryPK() {
	}
	public int getIdbackofficePasswordRecovery() {
		return this.idbackofficePasswordRecovery;
	}
	public void setIdbackofficePasswordRecovery(int idbackofficePasswordRecovery) {
		this.idbackofficePasswordRecovery = idbackofficePasswordRecovery;
	}
	public int getBackofficeUserIdbackofficeUser() {
		return this.backofficeUserIdbackofficeUser;
	}
	public void setBackofficeUserIdbackofficeUser(int backofficeUserIdbackofficeUser) {
		this.backofficeUserIdbackofficeUser = backofficeUserIdbackofficeUser;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BackofficePasswordRecoveryPK)) {
			return false;
		}
		BackofficePasswordRecoveryPK castOther = (BackofficePasswordRecoveryPK)other;
		return 
			(this.idbackofficePasswordRecovery == castOther.idbackofficePasswordRecovery)
			&& (this.backofficeUserIdbackofficeUser == castOther.backofficeUserIdbackofficeUser);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idbackofficePasswordRecovery;
		hash = hash * prime + this.backofficeUserIdbackofficeUser;
		
		return hash;
	}
}