package com.oyeseva.entity.generated;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the gateway database table.
 * 
 */
@Entity
@Table(name="gateway")
@NamedQuery(name="Gateway.findAll", query="SELECT g FROM Gateway g")
public class Gateway implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int idgateway;

	public Gateway() {
	}

	public int getIdgateway() {
		return this.idgateway;
	}

	public void setIdgateway(int idgateway) {
		this.idgateway = idgateway;
	}

}