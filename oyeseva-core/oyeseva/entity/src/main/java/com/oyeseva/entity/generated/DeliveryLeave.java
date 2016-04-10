package com.oyeseva.entity.generated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the delivery_leave database table.
 * 
 */
@Entity
@Table(name="delivery_leave")
@NamedQuery(name="DeliveryLeave.findAll", query="SELECT d FROM DeliveryLeave d")
public class DeliveryLeave implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="delivery_iddelivery", unique=true, nullable=false)
	private int deliveryIddelivery;

	@Column(name="delivery_leave_change_log", length=45)
	private String deliveryLeaveChangeLog;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="delivery_leave_end_date")
	private Date deliveryLeaveEndDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="delivery_leave_start_date")
	private Date deliveryLeaveStartDate;

	@Column(name="delivery_leave_status", length=45)
	private String deliveryLeaveStatus;

	//bi-directional one-to-one association to Delivery
	@OneToOne
	@JoinColumn(name="delivery_iddelivery", nullable=false, insertable=false, updatable=false)
	private Delivery delivery;

	public DeliveryLeave() {
	}

	public int getDeliveryIddelivery() {
		return this.deliveryIddelivery;
	}

	public void setDeliveryIddelivery(int deliveryIddelivery) {
		this.deliveryIddelivery = deliveryIddelivery;
	}

	public String getDeliveryLeaveChangeLog() {
		return this.deliveryLeaveChangeLog;
	}

	public void setDeliveryLeaveChangeLog(String deliveryLeaveChangeLog) {
		this.deliveryLeaveChangeLog = deliveryLeaveChangeLog;
	}

	public Date getDeliveryLeaveEndDate() {
		return this.deliveryLeaveEndDate;
	}

	public void setDeliveryLeaveEndDate(Date deliveryLeaveEndDate) {
		this.deliveryLeaveEndDate = deliveryLeaveEndDate;
	}

	public Date getDeliveryLeaveStartDate() {
		return this.deliveryLeaveStartDate;
	}

	public void setDeliveryLeaveStartDate(Date deliveryLeaveStartDate) {
		this.deliveryLeaveStartDate = deliveryLeaveStartDate;
	}

	public String getDeliveryLeaveStatus() {
		return this.deliveryLeaveStatus;
	}

	public void setDeliveryLeaveStatus(String deliveryLeaveStatus) {
		this.deliveryLeaveStatus = deliveryLeaveStatus;
	}

	public Delivery getDelivery() {
		return this.delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

}