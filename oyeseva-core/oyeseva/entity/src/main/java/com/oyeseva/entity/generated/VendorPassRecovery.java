package com.oyeseva.entity.generated;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the vendor_pass_recovery database table.
 * 
 */
@Entity
@Table(name="vendor_pass_recovery")
@NamedQuery(name="VendorPassRecovery.findAll", query="SELECT v FROM VendorPassRecovery v")
public class VendorPassRecovery implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private VendorPassRecoveryPK id;

	//bi-directional many-to-one association to Vendor
	@ManyToOne
	@JoinColumn(name="vendor_idvendor", nullable=false, insertable=false, updatable=false)
	private Vendor vendor;

	public VendorPassRecovery() {
	}

	public VendorPassRecoveryPK getId() {
		return this.id;
	}

	public void setId(VendorPassRecoveryPK id) {
		this.id = id;
	}

	public Vendor getVendor() {
		return this.vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

}