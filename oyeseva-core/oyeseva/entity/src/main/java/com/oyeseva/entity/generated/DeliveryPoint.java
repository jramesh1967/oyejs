package com.oyeseva.entity.generated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the delivery_point database table.
 * 
 */
@Entity
@Table(name="delivery_point")
@NamedQuery(name="DeliveryPoint.findAll", query="SELECT d FROM DeliveryPoint d")
public class DeliveryPoint implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DeliveryPointPK id;

	//bi-directional many-to-one association to Halt
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="halt_idhalt", referencedColumnName="idhalt", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name="halt_station_idstation", referencedColumnName="station_idstation", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name="halt_train_idtrain", referencedColumnName="train_idtrain", nullable=false, insertable=false, updatable=false)
		})
	private Halt halt;

	//bi-directional many-to-one association to DeliveryPointHasOrder
	@OneToMany(mappedBy="deliveryPoint")
	private List<DeliveryPointHasOrder> deliveryPointHasOrders;

	public DeliveryPoint() {
	}

	public DeliveryPointPK getId() {
		return this.id;
	}

	public void setId(DeliveryPointPK id) {
		this.id = id;
	}

	public Halt getHalt() {
		return this.halt;
	}

	public void setHalt(Halt halt) {
		this.halt = halt;
	}

	public List<DeliveryPointHasOrder> getDeliveryPointHasOrders() {
		return this.deliveryPointHasOrders;
	}

	public void setDeliveryPointHasOrders(List<DeliveryPointHasOrder> deliveryPointHasOrders) {
		this.deliveryPointHasOrders = deliveryPointHasOrders;
	}

	public DeliveryPointHasOrder addDeliveryPointHasOrder(DeliveryPointHasOrder deliveryPointHasOrder) {
		getDeliveryPointHasOrders().add(deliveryPointHasOrder);
		deliveryPointHasOrder.setDeliveryPoint(this);

		return deliveryPointHasOrder;
	}

	public DeliveryPointHasOrder removeDeliveryPointHasOrder(DeliveryPointHasOrder deliveryPointHasOrder) {
		getDeliveryPointHasOrders().remove(deliveryPointHasOrder);
		deliveryPointHasOrder.setDeliveryPoint(null);

		return deliveryPointHasOrder;
	}

}