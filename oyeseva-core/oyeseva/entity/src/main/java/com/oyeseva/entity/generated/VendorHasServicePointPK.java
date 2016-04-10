package com.oyeseva.entity.generated;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the vendor_has_service_point database table.
 * 
 */
@Embeddable
public class VendorHasServicePointPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="vendor_idvendor", insertable=false, updatable=false, unique=true, nullable=false)
	private int vendorIdvendor;

	@Column(name="service_point_idservice_point", insertable=false, updatable=false, unique=true, nullable=false)
	private int servicePointIdservicePoint;

	@Column(name="catalog_idcatalog", insertable=false, updatable=false, unique=true, nullable=false)
	private int catalogIdcatalog;

	public VendorHasServicePointPK() {
	}
	public int getVendorIdvendor() {
		return this.vendorIdvendor;
	}
	public void setVendorIdvendor(int vendorIdvendor) {
		this.vendorIdvendor = vendorIdvendor;
	}
	public int getServicePointIdservicePoint() {
		return this.servicePointIdservicePoint;
	}
	public void setServicePointIdservicePoint(int servicePointIdservicePoint) {
		this.servicePointIdservicePoint = servicePointIdservicePoint;
	}
	public int getCatalogIdcatalog() {
		return this.catalogIdcatalog;
	}
	public void setCatalogIdcatalog(int catalogIdcatalog) {
		this.catalogIdcatalog = catalogIdcatalog;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof VendorHasServicePointPK)) {
			return false;
		}
		VendorHasServicePointPK castOther = (VendorHasServicePointPK)other;
		return 
			(this.vendorIdvendor == castOther.vendorIdvendor)
			&& (this.servicePointIdservicePoint == castOther.servicePointIdservicePoint)
			&& (this.catalogIdcatalog == castOther.catalogIdcatalog);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.vendorIdvendor;
		hash = hash * prime + this.servicePointIdservicePoint;
		hash = hash * prime + this.catalogIdcatalog;
		
		return hash;
	}
}