package com.cm.entity;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int companyId;
	
	private String companyName;
    private String companyAddress;
    private String companyContact;
    private String companyServicePlan;

	
	@OneToMany(mappedBy="company",cascade = CascadeType.ALL)
	private List<User>users;
	
	@OneToMany(mappedBy="company1",cascade = CascadeType.ALL)
	private List<Courier>couriers;

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanyContact() {
		return companyContact;
	}

	public void setCompanyContact(String companyContact) {
		this.companyContact = companyContact;
	}

	public String getCompanyServicePlan() {
		return companyServicePlan;
	}

	public void setCompanyServicePlan(String companyServicePlan) {
		this.companyServicePlan = companyServicePlan;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Courier> getCouriers() {
		return couriers;
	}

	public void setCouriers(List<Courier> couriers) {
		this.couriers = couriers;
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", companyAddress=" + companyAddress
				+ ", companyContact=" + companyContact + ", companyServiceplan=" + companyServicePlan + ", users="
				+ users + ", couriers=" + couriers + "]";
	}

	
	
	
	
}
