package com.oyeseva.entity.generated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the service_point database table.
 * 
 */
@Entity
@Table(name="service_point")
@NamedQuery(name="ServicePoint.findAll", query="SELECT s FROM ServicePoint s")
public class ServicePoint implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idservice_point", unique=true, nullable=false)
	private int idservicePoint;

	//bi-directional many-to-many association to Delivery
	@ManyToMany
	@JoinTable(
		name="delivery_has_service_point"
		, joinColumns={
			@JoinColumn(name="service_point_idservice_point", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="delivery_iddelivery", nullable=false)
			}
		)
	private List<Delivery> deliveries;

	//bi-directional many-to-one association to VendorHasServicePoint
	@OneToMany(mappedBy="servicePoint")
	private List<VendorHasServicePoint> vendorHasServicePoints;

	public ServicePoint() {
	}

	public int getIdservicePoint() {
		return this.idservicePoint;
	}

	public void setIdservicePoint(int idservicePoint) {
		this.idservicePoint = idservicePoint;
	}

	public List<Delivery> getDeliveries() {
		return this.deliveries;
	}

	public void setDeliveries(List<Delivery> deliveries) {
		this.deliveries = deliveries;
	}

	public List<VendorHasServicePoint> getVendorHasServicePoints() {
		return this.vendorHasServicePoints;
	}

	public void setVendorHasServicePoints(List<VendorHasServicePoint> vendorHasServicePoints) {
		this.vendorHasServicePoints = vendorHasServicePoints;
	}

	public VendorHasServicePoint addVendorHasServicePoint(VendorHasServicePoint vendorHasServicePoint) {
		getVendorHasServicePoints().add(vendorHasServicePoint);
		vendorHasServicePoint.setServicePoint(this);

		return vendorHasServicePoint;
	}

	public VendorHasServicePoint removeVendorHasServicePoint(VendorHasServicePoint vendorHasServicePoint) {
		getVendorHasServicePoints().remove(vendorHasServicePoint);
		vendorHasServicePoint.setServicePoint(null);

		return vendorHasServicePoint;
	}

}