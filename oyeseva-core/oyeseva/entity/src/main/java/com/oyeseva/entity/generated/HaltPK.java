package com.oyeseva.entity.generated;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the halt database table.
 * 
 */
@Embeddable
public class HaltPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false)
	private int idhalt;

	@Column(name="train_idtrain", insertable=false, updatable=false, unique=true, nullable=false)
	private int trainIdtrain;

	@Column(name="station_idstation", insertable=false, updatable=false, unique=true, nullable=false)
	private int stationIdstation;

	public HaltPK() {
	}
	public int getIdhalt() {
		return this.idhalt;
	}
	public void setIdhalt(int idhalt) {
		this.idhalt = idhalt;
	}
	public int getTrainIdtrain() {
		return this.trainIdtrain;
	}
	public void setTrainIdtrain(int trainIdtrain) {
		this.trainIdtrain = trainIdtrain;
	}
	public int getStationIdstation() {
		return this.stationIdstation;
	}
	public void setStationIdstation(int stationIdstation) {
		this.stationIdstation = stationIdstation;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof HaltPK)) {
			return false;
		}
		HaltPK castOther = (HaltPK)other;
		return 
			(this.idhalt == castOther.idhalt)
			&& (this.trainIdtrain == castOther.trainIdtrain)
			&& (this.stationIdstation == castOther.stationIdstation);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idhalt;
		hash = hash * prime + this.trainIdtrain;
		hash = hash * prime + this.stationIdstation;
		
		return hash;
	}
}