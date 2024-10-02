package com.cm.service;

import com.cm.entity.Company;

public interface CompanyService {
	public Company saveCompany(Company company,String adminName, String adminEmail, String adminPassword);
}
