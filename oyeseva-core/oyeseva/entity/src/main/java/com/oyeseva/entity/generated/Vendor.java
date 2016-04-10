package com.oyeseva.entity.generated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the vendor database table.
 * 
 */
@Entity
@Table(name="vendor")
@NamedQuery(name="Vendor.findAll", query="SELECT v FROM Vendor v")
public class Vendor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int idvendor;

	//bi-directional many-to-one association to VendorHasServicePoint
	@OneToMany(mappedBy="vendor")
	private List<VendorHasServicePoint> vendorHasServicePoints;

	//bi-directional many-to-one association to VendorPassRecovery
	@OneToMany(mappedBy="vendor")
	private List<VendorPassRecovery> vendorPassRecoveries;

	public Vendor() {
	}

	public int getIdvendor() {
		return this.idvendor;
	}

	public void setIdvendor(int idvendor) {
		this.idvendor = idvendor;
	}

	public List<VendorHasServicePoint> getVendorHasServicePoints() {
		return this.vendorHasServicePoints;
	}

	public void setVendorHasServicePoints(List<VendorHasServicePoint> vendorHasServicePoints) {
		this.vendorHasServicePoints = vendorHasServicePoints;
	}

	public VendorHasServicePoint addVendorHasServicePoint(VendorHasServicePoint vendorHasServicePoint) {
		getVendorHasServicePoints().add(vendorHasServicePoint);
		vendorHasServicePoint.setVendor(this);

		return vendorHasServicePoint;
	}

	public VendorHasServicePoint removeVendorHasServicePoint(VendorHasServicePoint vendorHasServicePoint) {
		getVendorHasServicePoints().remove(vendorHasServicePoint);
		vendorHasServicePoint.setVendor(null);

		return vendorHasServicePoint;
	}

	public List<VendorPassRecovery> getVendorPassRecoveries() {
		return this.vendorPassRecoveries;
	}

	public void setVendorPassRecoveries(List<VendorPassRecovery> vendorPassRecoveries) {
		this.vendorPassRecoveries = vendorPassRecoveries;
	}

	public VendorPassRecovery addVendorPassRecovery(VendorPassRecovery vendorPassRecovery) {
		getVendorPassRecoveries().add(vendorPassRecovery);
		vendorPassRecovery.setVendor(this);

		return vendorPassRecovery;
	}

	public VendorPassRecovery removeVendorPassRecovery(VendorPassRecovery vendorPassRecovery) {
		getVendorPassRecoveries().remove(vendorPassRecovery);
		vendorPassRecovery.setVendor(null);

		return vendorPassRecovery;
	}

}