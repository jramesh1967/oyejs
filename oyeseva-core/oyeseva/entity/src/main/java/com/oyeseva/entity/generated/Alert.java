package com.oyeseva.entity.generated;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the alert database table.
 * 
 */
@Entity
@Table(name="alert")
@NamedQuery(name="Alert.findAll", query="SELECT a FROM Alert a")
public class Alert implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int idalert;

	public Alert() {
	}

	public int getIdalert() {
		return this.idalert;
	}

	public void setIdalert(int idalert) {
		this.idalert = idalert;
	}

}