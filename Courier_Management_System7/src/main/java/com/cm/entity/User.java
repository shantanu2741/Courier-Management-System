package com.cm.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	private String name;
	private String email;
	private String gender;
	private String password;
	private String address;
	private String role;
	private String contact;
	
	@ManyToOne
	@JoinColumn(name = "companyId")
	private Company company;
	
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL)
	private List<Courier>couriers;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Courier> getCouriers() {
		return couriers;
	}

	public void setCouriers(List<Courier> couriers) {
		this.couriers = couriers;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", gender=" + gender + ", password="
				+ password + ", address=" + address + ", role=" + role + ", contact=" + contact + ", company=" + company
				+ ", couriers=" + couriers + "]";
	}

	public User(Integer id, String name, String email, String gender, String password, String address, String role,
			String contact, Company company, List<Courier> couriers) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.password = password;
		this.address = address;
		this.role = role;
		this.contact = contact;
		this.company = company;
		this.couriers = couriers;
	}

	public User() {
		
	}
}
