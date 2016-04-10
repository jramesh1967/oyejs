package com.oyeseva.entity.generated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the delivery database table.
 * 
 */
@Entity
@Table(name="delivery")
@NamedQuery(name="Delivery.findAll", query="SELECT d FROM Delivery d")
public class Delivery implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int iddelivery;

	@Column(name="delivery_address", nullable=false, length=250)
	private String deliveryAddress;

	@Column(name="delivery_availability_days", nullable=false, length=45)
	private String deliveryAvailabilityDays;

	@Column(name="delivery_availability_time", nullable=false, length=45)
	private String deliveryAvailabilityTime;

	@Column(name="delivery_change_log", length=45)
	private String deliveryChangeLog;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="delivery_dob", nullable=false)
	private Date deliveryDob;

	@Column(name="delivery_guardian", length=250)
	private String deliveryGuardian;

	@Column(name="delivery_guardian_mobile", length=45)
	private String deliveryGuardianMobile;

	@Lob
	@Column(name="delivery_id_proof_doc")
	private byte[] deliveryIdProofDoc;

	@Column(name="delivery_id_proof_doc_path", length=255)
	private String deliveryIdProofDocPath;

	@Column(name="delivery_id_proof_refnum", length=45)
	private String deliveryIdProofRefnum;

	@Column(name="delivery_id_proof_type", nullable=false, length=50)
	private String deliveryIdProofType;

	@Column(name="delivery_mobile", nullable=false, length=45)
	private String deliveryMobile;

	@Column(name="delivery_name", nullable=false, length=45)
	private String deliveryName;

	@Column(name="delivery_nick_name", nullable=false, length=75)
	private String deliveryNickName;

	@Column(name="delivery_notes", length=45)
	private String deliveryNotes;

	@Column(name="delivery_password", length=45)
	private String deliveryPassword;

	@Lob
	@Column(name="delivery_profile_pic")
	private byte[] deliveryProfilePic;

	@Column(name="delivery_profile_pic_path", length=255)
	private String deliveryProfilePicPath;

	@Column(name="delivery_role", length=45)
	private String deliveryRole;

	@Column(name="delivery_sex", nullable=false, length=1)
	private String deliverySex;

	@Column(name="delivery_skype", length=150)
	private String deliverySkype;

	@Column(name="delivery_status", nullable=false, length=45)
	private String deliveryStatus;

	//bi-directional many-to-one association to DeliveryAllocation
	@OneToMany(mappedBy="delivery")
	private List<DeliveryAllocation> deliveryAllocations;

	//bi-directional many-to-many association to Delivery
	@ManyToMany
	@JoinTable(
		name="delivery_has_delivery"
		, joinColumns={
			@JoinColumn(name="delivery_iddelivery1", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="delivery_iddelivery", nullable=false)
			}
		)
	private List<Delivery> deliveries1;

	//bi-directional many-to-many association to Delivery
	@ManyToMany(mappedBy="deliveries1")
	private List<Delivery> deliveries2;

	//bi-directional many-to-many association to ServicePoint
	@ManyToMany(mappedBy="deliveries")
	private List<ServicePoint> servicePoints;

	//bi-directional one-to-one association to DeliveryLeave
	@OneToOne(mappedBy="delivery")
	private DeliveryLeave deliveryLeave;

	//bi-directional many-to-one association to DeliveryPassRecovery
	@OneToMany(mappedBy="delivery")
	private List<DeliveryPassRecovery> deliveryPassRecoveries;

	//bi-directional many-to-one association to Payment
	@OneToMany(mappedBy="delivery")
	private List<Payment> payments;

	public Delivery() {
	}

	public int getIddelivery() {
		return this.iddelivery;
	}

	public void setIddelivery(int iddelivery) {
		this.iddelivery = iddelivery;
	}

	public String getDeliveryAddress() {
		return this.deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getDeliveryAvailabilityDays() {
		return this.deliveryAvailabilityDays;
	}

	public void setDeliveryAvailabilityDays(String deliveryAvailabilityDays) {
		this.deliveryAvailabilityDays = deliveryAvailabilityDays;
	}

	public String getDeliveryAvailabilityTime() {
		return this.deliveryAvailabilityTime;
	}

	public void setDeliveryAvailabilityTime(String deliveryAvailabilityTime) {
		this.deliveryAvailabilityTime = deliveryAvailabilityTime;
	}

	public String getDeliveryChangeLog() {
		return this.deliveryChangeLog;
	}

	public void setDeliveryChangeLog(String deliveryChangeLog) {
		this.deliveryChangeLog = deliveryChangeLog;
	}

	public Date getDeliveryDob() {
		return this.deliveryDob;
	}

	public void setDeliveryDob(Date deliveryDob) {
		this.deliveryDob = deliveryDob;
	}

	public String getDeliveryGuardian() {
		return this.deliveryGuardian;
	}

	public void setDeliveryGuardian(String deliveryGuardian) {
		this.deliveryGuardian = deliveryGuardian;
	}

	public String getDeliveryGuardianMobile() {
		return this.deliveryGuardianMobile;
	}

	public void setDeliveryGuardianMobile(String deliveryGuardianMobile) {
		this.deliveryGuardianMobile = deliveryGuardianMobile;
	}

	public byte[] getDeliveryIdProofDoc() {
		return this.deliveryIdProofDoc;
	}

	public void setDeliveryIdProofDoc(byte[] deliveryIdProofDoc) {
		this.deliveryIdProofDoc = deliveryIdProofDoc;
	}

	public String getDeliveryIdProofDocPath() {
		return this.deliveryIdProofDocPath;
	}

	public void setDeliveryIdProofDocPath(String deliveryIdProofDocPath) {
		this.deliveryIdProofDocPath = deliveryIdProofDocPath;
	}

	public String getDeliveryIdProofRefnum() {
		return this.deliveryIdProofRefnum;
	}

	public void setDeliveryIdProofRefnum(String deliveryIdProofRefnum) {
		this.deliveryIdProofRefnum = deliveryIdProofRefnum;
	}

	public String getDeliveryIdProofType() {
		return this.deliveryIdProofType;
	}

	public void setDeliveryIdProofType(String deliveryIdProofType) {
		this.deliveryIdProofType = deliveryIdProofType;
	}

	public String getDeliveryMobile() {
		return this.deliveryMobile;
	}

	public void setDeliveryMobile(String deliveryMobile) {
		this.deliveryMobile = deliveryMobile;
	}

	public String getDeliveryName() {
		return this.deliveryName;
	}

	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}

	public String getDeliveryNickName() {
		return this.deliveryNickName;
	}

	public void setDeliveryNickName(String deliveryNickName) {
		this.deliveryNickName = deliveryNickName;
	}

	public String getDeliveryNotes() {
		return this.deliveryNotes;
	}

	public void setDeliveryNotes(String deliveryNotes) {
		this.deliveryNotes = deliveryNotes;
	}

	public String getDeliveryPassword() {
		return this.deliveryPassword;
	}

	public void setDeliveryPassword(String deliveryPassword) {
		this.deliveryPassword = deliveryPassword;
	}

	public byte[] getDeliveryProfilePic() {
		return this.deliveryProfilePic;
	}

	public void setDeliveryProfilePic(byte[] deliveryProfilePic) {
		this.deliveryProfilePic = deliveryProfilePic;
	}

	public String getDeliveryProfilePicPath() {
		return this.deliveryProfilePicPath;
	}

	public void setDeliveryProfilePicPath(String deliveryProfilePicPath) {
		this.deliveryProfilePicPath = deliveryProfilePicPath;
	}

	public String getDeliveryRole() {
		return this.deliveryRole;
	}

	public void setDeliveryRole(String deliveryRole) {
		this.deliveryRole = deliveryRole;
	}

	public String getDeliverySex() {
		return this.deliverySex;
	}

	public void setDeliverySex(String deliverySex) {
		this.deliverySex = deliverySex;
	}

	public String getDeliverySkype() {
		return this.deliverySkype;
	}

	public void setDeliverySkype(String deliverySkype) {
		this.deliverySkype = deliverySkype;
	}

	public String getDeliveryStatus() {
		return this.deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public List<DeliveryAllocation> getDeliveryAllocations() {
		return this.deliveryAllocations;
	}

	public void setDeliveryAllocations(List<DeliveryAllocation> deliveryAllocations) {
		this.deliveryAllocations = deliveryAllocations;
	}

	public DeliveryAllocation addDeliveryAllocation(DeliveryAllocation deliveryAllocation) {
		getDeliveryAllocations().add(deliveryAllocation);
		deliveryAllocation.setDelivery(this);

		return deliveryAllocation;
	}

	public DeliveryAllocation removeDeliveryAllocation(DeliveryAllocation deliveryAllocation) {
		getDeliveryAllocations().remove(deliveryAllocation);
		deliveryAllocation.setDelivery(null);

		return deliveryAllocation;
	}

	public List<Delivery> getDeliveries1() {
		return this.deliveries1;
	}

	public void setDeliveries1(List<Delivery> deliveries1) {
		this.deliveries1 = deliveries1;
	}

	public List<Delivery> getDeliveries2() {
		return this.deliveries2;
	}

	public void setDeliveries2(List<Delivery> deliveries2) {
		this.deliveries2 = deliveries2;
	}

	public List<ServicePoint> getServicePoints() {
		return this.servicePoints;
	}

	public void setServicePoints(List<ServicePoint> servicePoints) {
		this.servicePoints = servicePoints;
	}

	public DeliveryLeave getDeliveryLeave() {
		return this.deliveryLeave;
	}

	public void setDeliveryLeave(DeliveryLeave deliveryLeave) {
		this.deliveryLeave = deliveryLeave;
	}

	public List<DeliveryPassRecovery> getDeliveryPassRecoveries() {
		return this.deliveryPassRecoveries;
	}

	public void setDeliveryPassRecoveries(List<DeliveryPassRecovery> deliveryPassRecoveries) {
		this.deliveryPassRecoveries = deliveryPassRecoveries;
	}

	public DeliveryPassRecovery addDeliveryPassRecovery(DeliveryPassRecovery deliveryPassRecovery) {
		getDeliveryPassRecoveries().add(deliveryPassRecovery);
		deliveryPassRecovery.setDelivery(this);

		return deliveryPassRecovery;
	}

	public DeliveryPassRecovery removeDeliveryPassRecovery(DeliveryPassRecovery deliveryPassRecovery) {
		getDeliveryPassRecoveries().remove(deliveryPassRecovery);
		deliveryPassRecovery.setDelivery(null);

		return deliveryPassRecovery;
	}

	public List<Payment> getPayments() {
		return this.payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public Payment addPayment(Payment payment) {
		getPayments().add(payment);
		payment.setDelivery(this);

		return payment;
	}

	public Payment removePayment(Payment payment) {
		getPayments().remove(payment);
		payment.setDelivery(null);

		return payment;
	}

}