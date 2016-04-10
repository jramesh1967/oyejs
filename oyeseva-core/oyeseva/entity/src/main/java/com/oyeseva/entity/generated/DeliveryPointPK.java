package com.oyeseva.entity.generated;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the delivery_point database table.
 * 
 */
@Embeddable
public class DeliveryPointPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="iddelivery_point", unique=true, nullable=false)
	private int iddeliveryPoint;

	@Column(name="halt_idhalt", insertable=false, updatable=false, unique=true, nullable=false)
	private int haltIdhalt;

	@Column(name="halt_train_idtrain", insertable=false, updatable=false, unique=true, nullable=false)
	private int haltTrainIdtrain;

	@Column(name="halt_station_idstation", insertable=false, updatable=false, unique=true, nullable=false)
	private int haltStationIdstation;

	public DeliveryPointPK() {
	}
	public int getIddeliveryPoint() {
		return this.iddeliveryPoint;
	}
	public void setIddeliveryPoint(int iddeliveryPoint) {
		this.iddeliveryPoint = iddeliveryPoint;
	}
	public int getHaltIdhalt() {
		return this.haltIdhalt;
	}
	public void setHaltIdhalt(int haltIdhalt) {
		this.haltIdhalt = haltIdhalt;
	}
	public int getHaltTrainIdtrain() {
		return this.haltTrainIdtrain;
	}
	public void setHaltTrainIdtrain(int haltTrainIdtrain) {
		this.haltTrainIdtrain = haltTrainIdtrain;
	}
	public int getHaltStationIdstation() {
		return this.haltStationIdstation;
	}
	public void setHaltStationIdstation(int haltStationIdstation) {
		this.haltStationIdstation = haltStationIdstation;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DeliveryPointPK)) {
			return false;
		}
		DeliveryPointPK castOther = (DeliveryPointPK)other;
		return 
			(this.iddeliveryPoint == castOther.iddeliveryPoint)
			&& (this.haltIdhalt == castOther.haltIdhalt)
			&& (this.haltTrainIdtrain == castOther.haltTrainIdtrain)
			&& (this.haltStationIdstation == castOther.haltStationIdstation);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.iddeliveryPoint;
		hash = hash * prime + this.haltIdhalt;
		hash = hash * prime + this.haltTrainIdtrain;
		hash = hash * prime + this.haltStationIdstation;
		
		return hash;
	}
}