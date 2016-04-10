package com.oyeseva.entity.generated;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the delivery_point_has_order database table.
 * 
 */
@Embeddable
public class DeliveryPointHasOrderPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="delivery_point_iddelivery_point", insertable=false, updatable=false, unique=true, nullable=false)
	private int deliveryPointIddeliveryPoint;

	@Column(name="delivery_point_halt_idhalt", insertable=false, updatable=false, unique=true, nullable=false)
	private int deliveryPointHaltIdhalt;

	@Column(name="delivery_point_halt_train_idtrain", insertable=false, updatable=false, unique=true, nullable=false)
	private int deliveryPointHaltTrainIdtrain;

	@Column(name="delivery_point_halt_station_idstation", insertable=false, updatable=false, unique=true, nullable=false)
	private int deliveryPointHaltStationIdstation;

	@Column(name="order_idorder", unique=true, nullable=false)
	private int orderIdorder;

	@Column(name="order_payment_idpayment", unique=true, nullable=false)
	private int orderPaymentIdpayment;

	public DeliveryPointHasOrderPK() {
	}
	public int getDeliveryPointIddeliveryPoint() {
		return this.deliveryPointIddeliveryPoint;
	}
	public void setDeliveryPointIddeliveryPoint(int deliveryPointIddeliveryPoint) {
		this.deliveryPointIddeliveryPoint = deliveryPointIddeliveryPoint;
	}
	public int getDeliveryPointHaltIdhalt() {
		return this.deliveryPointHaltIdhalt;
	}
	public void setDeliveryPointHaltIdhalt(int deliveryPointHaltIdhalt) {
		this.deliveryPointHaltIdhalt = deliveryPointHaltIdhalt;
	}
	public int getDeliveryPointHaltTrainIdtrain() {
		return this.deliveryPointHaltTrainIdtrain;
	}
	public void setDeliveryPointHaltTrainIdtrain(int deliveryPointHaltTrainIdtrain) {
		this.deliveryPointHaltTrainIdtrain = deliveryPointHaltTrainIdtrain;
	}
	public int getDeliveryPointHaltStationIdstation() {
		return this.deliveryPointHaltStationIdstation;
	}
	public void setDeliveryPointHaltStationIdstation(int deliveryPointHaltStationIdstation) {
		this.deliveryPointHaltStationIdstation = deliveryPointHaltStationIdstation;
	}
	public int getOrderIdorder() {
		return this.orderIdorder;
	}
	public void setOrderIdorder(int orderIdorder) {
		this.orderIdorder = orderIdorder;
	}
	public int getOrderPaymentIdpayment() {
		return this.orderPaymentIdpayment;
	}
	public void setOrderPaymentIdpayment(int orderPaymentIdpayment) {
		this.orderPaymentIdpayment = orderPaymentIdpayment;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DeliveryPointHasOrderPK)) {
			return false;
		}
		DeliveryPointHasOrderPK castOther = (DeliveryPointHasOrderPK)other;
		return 
			(this.deliveryPointIddeliveryPoint == castOther.deliveryPointIddeliveryPoint)
			&& (this.deliveryPointHaltIdhalt == castOther.deliveryPointHaltIdhalt)
			&& (this.deliveryPointHaltTrainIdtrain == castOther.deliveryPointHaltTrainIdtrain)
			&& (this.deliveryPointHaltStationIdstation == castOther.deliveryPointHaltStationIdstation)
			&& (this.orderIdorder == castOther.orderIdorder)
			&& (this.orderPaymentIdpayment == castOther.orderPaymentIdpayment);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.deliveryPointIddeliveryPoint;
		hash = hash * prime + this.deliveryPointHaltIdhalt;
		hash = hash * prime + this.deliveryPointHaltTrainIdtrain;
		hash = hash * prime + this.deliveryPointHaltStationIdstation;
		hash = hash * prime + this.orderIdorder;
		hash = hash * prime + this.orderPaymentIdpayment;
		
		return hash;
	}
}