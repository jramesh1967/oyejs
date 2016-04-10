package com.oyeseva.entity.generated;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the delivery_point_has_order database table.
 * 
 */
@Entity
@Table(name="delivery_point_has_order")
@NamedQuery(name="DeliveryPointHasOrder.findAll", query="SELECT d FROM DeliveryPointHasOrder d")
public class DeliveryPointHasOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DeliveryPointHasOrderPK id;

	//bi-directional many-to-one association to DeliveryPoint
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="delivery_point_halt_idhalt", referencedColumnName="halt_idhalt", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name="delivery_point_halt_station_idstation", referencedColumnName="halt_station_idstation", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name="delivery_point_halt_train_idtrain", referencedColumnName="halt_train_idtrain", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name="delivery_point_iddelivery_point", referencedColumnName="iddelivery_point", nullable=false, insertable=false, updatable=false)
		})
	private DeliveryPoint deliveryPoint;

	public DeliveryPointHasOrder() {
	}

	public DeliveryPointHasOrderPK getId() {
		return this.id;
	}

	public void setId(DeliveryPointHasOrderPK id) {
		this.id = id;
	}

	public DeliveryPoint getDeliveryPoint() {
		return this.deliveryPoint;
	}

	public void setDeliveryPoint(DeliveryPoint deliveryPoint) {
		this.deliveryPoint = deliveryPoint;
	}

}