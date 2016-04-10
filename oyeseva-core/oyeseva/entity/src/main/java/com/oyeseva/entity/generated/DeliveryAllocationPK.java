package com.oyeseva.entity.generated;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the delivery_allocation database table.
 * 
 */
@Embeddable
public class DeliveryAllocationPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="iddelivery_allocation", unique=true, nullable=false)
	private int iddeliveryAllocation;

	@Column(name="order_idorder", unique=true, nullable=false)
	private int orderIdorder;

	@Column(name="order_payment_idpayment", unique=true, nullable=false)
	private int orderPaymentIdpayment;

	@Column(name="delivery_iddelivery", insertable=false, updatable=false, unique=true, nullable=false)
	private int deliveryIddelivery;

	public DeliveryAllocationPK() {
	}
	public int getIddeliveryAllocation() {
		return this.iddeliveryAllocation;
	}
	public void setIddeliveryAllocation(int iddeliveryAllocation) {
		this.iddeliveryAllocation = iddeliveryAllocation;
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
	public int getDeliveryIddelivery() {
		return this.deliveryIddelivery;
	}
	public void setDeliveryIddelivery(int deliveryIddelivery) {
		this.deliveryIddelivery = deliveryIddelivery;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DeliveryAllocationPK)) {
			return false;
		}
		DeliveryAllocationPK castOther = (DeliveryAllocationPK)other;
		return 
			(this.iddeliveryAllocation == castOther.iddeliveryAllocation)
			&& (this.orderIdorder == castOther.orderIdorder)
			&& (this.orderPaymentIdpayment == castOther.orderPaymentIdpayment)
			&& (this.deliveryIddelivery == castOther.deliveryIddelivery);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.iddeliveryAllocation;
		hash = hash * prime + this.orderIdorder;
		hash = hash * prime + this.orderPaymentIdpayment;
		hash = hash * prime + this.deliveryIddelivery;
		
		return hash;
	}
}