package com.cm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cm.entity.Company;

public interface CompanyRepository extends JpaRepository<Company,Integer>{

}
