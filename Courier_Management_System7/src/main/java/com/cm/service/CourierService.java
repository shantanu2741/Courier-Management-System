package com.cm.service;

import com.cm.entity.Courier;
import java.util.List;

public interface CourierService {
	public Courier saveCourier(Courier courier);
	
	public List<Courier> getAllCourier();

	public Courier getCourierById(Integer courierId);

	public boolean deleteCourier(Integer courierId);
	
	public boolean updateCourierStatus(Integer id,String status);
	
	public List<Courier> getCourierByUserId(Integer userId);
	
	public Boolean updateOrderStatus(Integer id,String status);
}

