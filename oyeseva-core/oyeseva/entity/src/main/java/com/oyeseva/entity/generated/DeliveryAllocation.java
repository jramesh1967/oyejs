package com.oyeseva.entity.generated;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the delivery_allocation database table.
 * 
 */
@Entity
@Table(name="delivery_allocation")
@NamedQuery(name="DeliveryAllocation.findAll", query="SELECT d FROM DeliveryAllocation d")
public class DeliveryAllocation implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DeliveryAllocationPK id;

	//bi-directional many-to-one association to Delivery
	@ManyToOne
	@JoinColumn(name="delivery_iddelivery", nullable=false, insertable=false, updatable=false)
	private Delivery delivery;

	public DeliveryAllocation() {
	}

	public DeliveryAllocationPK getId() {
		return this.id;
	}

	public void setId(DeliveryAllocationPK id) {
		this.id = id;
	}

	public Delivery getDelivery() {
		return this.delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

}