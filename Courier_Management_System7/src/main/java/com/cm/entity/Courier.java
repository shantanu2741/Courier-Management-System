package com.cm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Courier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer courierId;
	
	@ManyToOne
	@JoinColumn(name="id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="companyId")
	private Company company1;

	private String senderName;
	private String senderAddress;
	private String senderContact;

	private String receiverName;
	private String receiverAddress;
	private String receiverContact;
	
	private String courierDescription;
	private String courierWeight;
	private String courierDimentions;
	private String courierContent;
	private String courierType;
	
	private String status;

	public Integer getCourierId() {
		return courierId;
	}

	public void setCourierId(Integer courierId) {
		this.courierId = courierId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Company getCompany1() {
		return company1;
	}

	public void setCompany1(Company company1) {
		this.company1 = company1;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSenderAddress() {
		return senderAddress;
	}

	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}

	public String getSenderContact() {
		return senderContact;
	}

	public void setSenderContact(String senderContact) {
		this.senderContact = senderContact;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public String getReceiverContact() {
		return receiverContact;
	}

	public void setReceiverContact(String receiverContact) {
		this.receiverContact = receiverContact;
	}

	public String getCourierDescription() {
		return courierDescription;
	}

	public void setCourierDescription(String courierDescription) {
		this.courierDescription = courierDescription;
	}

	public String getCourierWeight() {
		return courierWeight;
	}

	public void setCourierWeight(String courierWeight) {
		this.courierWeight = courierWeight;
	}

	public String getCourierDimentions() {
		return courierDimentions;
	}

	public void setCourierDimentions(String courierDimentions) {
		this.courierDimentions = courierDimentions;
	}

	public String getCourierContent() {
		return courierContent;
	}

	public void setCourierContent(String courierContent) {
		this.courierContent = courierContent;
	}

	public String getCourierType() {
		return courierType;
	}

	public void setCourierType(String courierType) {
		this.courierType = courierType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Courier [courierId=" + courierId + ", user=" + user + ", company1=" + company1 + ", senderName="
				+ senderName + ", senderAddress=" + senderAddress + ", senderContact=" + senderContact
				+ ", receiverName=" + receiverName + ", receiverAddress=" + receiverAddress + ", receiverContact="
				+ receiverContact + ", courierDescription=" + courierDescription + ", courierWeight=" + courierWeight
				+ ", courierDimentions=" + courierDimentions + ", courierContent=" + courierContent + ", courierType="
				+ courierType + ", status=" + status + "]";
	}

	public Courier(Integer courierId, User user, Company company1, String senderName, String senderAddress,
			String senderContact, String receiverName, String receiverAddress, String receiverContact,
			String courierDescription, String courierWeight, String courierDimentions, String courierContent,
			String courierType, String status) {
		this.courierId = courierId;
		this.user = user;
		this.company1 = company1;
		this.senderName = senderName;
		this.senderAddress = senderAddress;
		this.senderContact = senderContact;
		this.receiverName = receiverName;
		this.receiverAddress = receiverAddress;
		this.receiverContact = receiverContact;
		this.courierDescription = courierDescription;
		this.courierWeight = courierWeight;
		this.courierDimentions = courierDimentions;
		this.courierContent = courierContent;
		this.courierType = courierType;
		this.status = status;
	}

	public Courier() {
	}

	
	
}
