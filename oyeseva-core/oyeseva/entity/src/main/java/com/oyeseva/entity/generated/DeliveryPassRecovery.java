package com.oyeseva.entity.generated;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the delivery_pass_recovery database table.
 * 
 */
@Entity
@Table(name="delivery_pass_recovery")
@NamedQuery(name="DeliveryPassRecovery.findAll", query="SELECT d FROM DeliveryPassRecovery d")
public class DeliveryPassRecovery implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DeliveryPassRecoveryPK id;

	//bi-directional many-to-one association to Delivery
	@ManyToOne
	@JoinColumn(name="delivery_iddelivery", nullable=false, insertable=false, updatable=false)
	private Delivery delivery;

	public DeliveryPassRecovery() {
	}

	public DeliveryPassRecoveryPK getId() {
		return this.id;
	}

	public void setId(DeliveryPassRecoveryPK id) {
		this.id = id;
	}

	public Delivery getDelivery() {
		return this.delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

}