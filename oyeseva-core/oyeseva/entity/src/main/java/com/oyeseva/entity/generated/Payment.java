package com.oyeseva.entity.generated;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the payment database table.
 * 
 */
@Entity
@Table(name="payment")
@NamedQuery(name="Payment.findAll", query="SELECT p FROM Payment p")
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int idpayment;

	//bi-directional many-to-one association to Delivery
	@ManyToOne
	@JoinColumn(name="delivery_iddelivery", nullable=false)
	private Delivery delivery;

	public Payment() {
	}

	public int getIdpayment() {
		return this.idpayment;
	}

	public void setIdpayment(int idpayment) {
		this.idpayment = idpayment;
	}

	public Delivery getDelivery() {
		return this.delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

}