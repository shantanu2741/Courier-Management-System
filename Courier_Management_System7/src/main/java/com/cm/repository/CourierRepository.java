package com.cm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cm.entity.Courier;

public interface CourierRepository extends JpaRepository<Courier,Integer>{
	List<Courier> findByUserId(Integer userId);
	
}