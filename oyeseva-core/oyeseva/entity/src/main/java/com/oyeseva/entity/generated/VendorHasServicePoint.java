package com.oyeseva.entity.generated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the vendor_has_service_point database table.
 * 
 */
@Entity
@Table(name="vendor_has_service_point")
@NamedQuery(name="VendorHasServicePoint.findAll", query="SELECT v FROM VendorHasServicePoint v")
public class VendorHasServicePoint implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private VendorHasServicePointPK id;

	//bi-directional many-to-many association to Halt
	@ManyToMany
	@JoinTable(
		name="halt_has_vendor_has_service_point"
		, joinColumns={
			@JoinColumn(name="vendor_has_service_point_catalog_idcatalog", referencedColumnName="catalog_idcatalog", nullable=false),
			@JoinColumn(name="vendor_has_service_point_service_point_idservice_point", referencedColumnName="service_point_idservice_point", nullable=false),
			@JoinColumn(name="vendor_has_service_point_vendor_idvendor", referencedColumnName="vendor_idvendor", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="halt_idhalt", referencedColumnName="idhalt", nullable=false),
			@JoinColumn(name="halt_station_idstation", referencedColumnName="station_idstation", nullable=false),
			@JoinColumn(name="halt_train_idtrain", referencedColumnName="train_idtrain", nullable=false)
			}
		)
	private List<Halt> halts;

	//bi-directional many-to-one association to Catalog
	@ManyToOne
	@JoinColumn(name="catalog_idcatalog", nullable=false, insertable=false, updatable=false)
	private Catalog catalog;

	//bi-directional many-to-one association to ServicePoint
	@ManyToOne
	@JoinColumn(name="service_point_idservice_point", nullable=false, insertable=false, updatable=false)
	private ServicePoint servicePoint;

	//bi-directional many-to-one association to Vendor
	@ManyToOne
	@JoinColumn(name="vendor_idvendor", nullable=false, insertable=false, updatable=false)
	private Vendor vendor;

	public VendorHasServicePoint() {
	}

	public VendorHasServicePointPK getId() {
		return this.id;
	}

	public void setId(VendorHasServicePointPK id) {
		this.id = id;
	}

	public List<Halt> getHalts() {
		return this.halts;
	}

	public void setHalts(List<Halt> halts) {
		this.halts = halts;
	}

	public Catalog getCatalog() {
		return this.catalog;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

	public ServicePoint getServicePoint() {
		return this.servicePoint;
	}

	public void setServicePoint(ServicePoint servicePoint) {
		this.servicePoint = servicePoint;
	}

	public Vendor getVendor() {
		return this.vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

}