package com.oyeseva.entity.generated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the halt database table.
 * 
 */
@Entity
@Table(name="halt")
@NamedQuery(name="Halt.findAll", query="SELECT h FROM Halt h")
public class Halt implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HaltPK id;

	@Column(nullable=false)
	private Time eta;

	@Column(nullable=false)
	private Time etd;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="halt_start_date")
	private Date haltStartDate;

	//bi-directional many-to-one association to DeliveryPoint
	@OneToMany(mappedBy="halt")
	private List<DeliveryPoint> deliveryPoints;

	//bi-directional many-to-one association to Station
	@ManyToOne
	@JoinColumn(name="station_idstation", nullable=false, insertable=false, updatable=false)
	private Station station;

	//bi-directional many-to-one association to Train
	@ManyToOne
	@JoinColumn(name="train_idtrain", nullable=false, insertable=false, updatable=false)
	private Train train;

	//bi-directional many-to-many association to VendorHasServicePoint
	@ManyToMany(mappedBy="halts")
	private List<VendorHasServicePoint> vendorHasServicePoints;

	public Halt() {
	}

	public HaltPK getId() {
		return this.id;
	}

	public void setId(HaltPK id) {
		this.id = id;
	}

	public Time getEta() {
		return this.eta;
	}

	public void setEta(Time eta) {
		this.eta = eta;
	}

	public Time getEtd() {
		return this.etd;
	}

	public void setEtd(Time etd) {
		this.etd = etd;
	}

	public Date getHaltStartDate() {
		return this.haltStartDate;
	}

	public void setHaltStartDate(Date haltStartDate) {
		this.haltStartDate = haltStartDate;
	}

	public List<DeliveryPoint> getDeliveryPoints() {
		return this.deliveryPoints;
	}

	public void setDeliveryPoints(List<DeliveryPoint> deliveryPoints) {
		this.deliveryPoints = deliveryPoints;
	}

	public DeliveryPoint addDeliveryPoint(DeliveryPoint deliveryPoint) {
		getDeliveryPoints().add(deliveryPoint);
		deliveryPoint.setHalt(this);

		return deliveryPoint;
	}

	public DeliveryPoint removeDeliveryPoint(DeliveryPoint deliveryPoint) {
		getDeliveryPoints().remove(deliveryPoint);
		deliveryPoint.setHalt(null);

		return deliveryPoint;
	}

	public Station getStation() {
		return this.station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public Train getTrain() {
		return this.train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	public List<VendorHasServicePoint> getVendorHasServicePoints() {
		return this.vendorHasServicePoints;
	}

	public void setVendorHasServicePoints(List<VendorHasServicePoint> vendorHasServicePoints) {
		this.vendorHasServicePoints = vendorHasServicePoints;
	}

}