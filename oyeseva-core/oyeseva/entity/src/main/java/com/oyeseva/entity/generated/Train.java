package com.oyeseva.entity.generated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the train database table.
 * 
 */
@Entity
@Table(name="train")
@NamedQuery(name="Train.findAll", query="SELECT t FROM Train t")
public class Train implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int idtrain;

	@Column(name="train_name", nullable=false, length=45)
	private String trainName;

	@Column(name="train_number", nullable=false, length=45)
	private String trainNumber;

	//bi-directional many-to-one association to Halt
	@OneToMany(mappedBy="train")
	private List<Halt> halts;

	public Train() {
	}

	public int getIdtrain() {
		return this.idtrain;
	}

	public void setIdtrain(int idtrain) {
		this.idtrain = idtrain;
	}

	public String getTrainName() {
		return this.trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getTrainNumber() {
		return this.trainNumber;
	}

	public void setTrainNumber(String trainNumber) {
		this.trainNumber = trainNumber;
	}

	public List<Halt> getHalts() {
		return this.halts;
	}

	public void setHalts(List<Halt> halts) {
		this.halts = halts;
	}

	public Halt addHalt(Halt halt) {
		getHalts().add(halt);
		halt.setTrain(this);

		return halt;
	}

	public Halt removeHalt(Halt halt) {
		getHalts().remove(halt);
		halt.setTrain(null);

		return halt;
	}

}