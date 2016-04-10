package com.oyeseva.entity.generated;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the vendor_pass_recovery database table.
 * 
 */
@Embeddable
public class VendorPassRecoveryPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="idvendor_pass_recovery", unique=true, nullable=false)
	private int idvendorPassRecovery;

	@Column(name="vendor_idvendor", insertable=false, updatable=false, unique=true, nullable=false)
	private int vendorIdvendor;

	public VendorPassRecoveryPK() {
	}
	public int getIdvendorPassRecovery() {
		return this.idvendorPassRecovery;
	}
	public void setIdvendorPassRecovery(int idvendorPassRecovery) {
		this.idvendorPassRecovery = idvendorPassRecovery;
	}
	public int getVendorIdvendor() {
		return this.vendorIdvendor;
	}
	public void setVendorIdvendor(int vendorIdvendor) {
		this.vendorIdvendor = vendorIdvendor;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof VendorPassRecoveryPK)) {
			return false;
		}
		VendorPassRecoveryPK castOther = (VendorPassRecoveryPK)other;
		return 
			(this.idvendorPassRecovery == castOther.idvendorPassRecovery)
			&& (this.vendorIdvendor == castOther.vendorIdvendor);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idvendorPassRecovery;
		hash = hash * prime + this.vendorIdvendor;
		
		return hash;
	}
}