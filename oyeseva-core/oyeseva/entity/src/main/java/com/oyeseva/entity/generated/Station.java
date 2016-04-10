package com.oyeseva.entity.generated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the station database table.
 * 
 */
@Entity
@Table(name="station")
@NamedQuery(name="Station.findAll", query="SELECT s FROM Station s")
public class Station implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int idstation;

	@Column(name="station_code", length=45)
	private String stationCode;

	@Column(name="station_name", length=45)
	private String stationName;

	//bi-directional many-to-one association to Halt
	@OneToMany(mappedBy="station")
	private List<Halt> halts;

	public Station() {
	}

	public int getIdstation() {
		return this.idstation;
	}

	public void setIdstation(int idstation) {
		this.idstation = idstation;
	}

	public String getStationCode() {
		return this.stationCode;
	}

	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}

	public String getStationName() {
		return this.stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public List<Halt> getHalts() {
		return this.halts;
	}

	public void setHalts(List<Halt> halts) {
		this.halts = halts;
	}

	public Halt addHalt(Halt halt) {
		getHalts().add(halt);
		halt.setStation(this);

		return halt;
	}

	public Halt removeHalt(Halt halt) {
		getHalts().remove(halt);
		halt.setStation(null);

		return halt;
	}

}