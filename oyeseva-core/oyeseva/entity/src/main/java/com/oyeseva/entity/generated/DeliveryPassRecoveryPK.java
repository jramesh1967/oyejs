package com.oyeseva.entity.generated;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the delivery_pass_recovery database table.
 * 
 */
@Embeddable
public class DeliveryPassRecoveryPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="iddelivery_pass_recovery", unique=true, nullable=false)
	private int iddeliveryPassRecovery;

	@Column(name="delivery_iddelivery", insertable=false, updatable=false, unique=true, nullable=false)
	private int deliveryIddelivery;

	public DeliveryPassRecoveryPK() {
	}
	public int getIddeliveryPassRecovery() {
		return this.iddeliveryPassRecovery;
	}
	public void setIddeliveryPassRecovery(int iddeliveryPassRecovery) {
		this.iddeliveryPassRecovery = iddeliveryPassRecovery;
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
		if (!(other instanceof DeliveryPassRecoveryPK)) {
			return false;
		}
		DeliveryPassRecoveryPK castOther = (DeliveryPassRecoveryPK)other;
		return 
			(this.iddeliveryPassRecovery == castOther.iddeliveryPassRecovery)
			&& (this.deliveryIddelivery == castOther.deliveryIddelivery);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.iddeliveryPassRecovery;
		hash = hash * prime + this.deliveryIddelivery;
		
		return hash;
	}
}