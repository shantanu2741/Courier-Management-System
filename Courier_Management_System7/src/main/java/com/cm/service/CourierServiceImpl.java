package com.cm.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;

import com.cm.entity.Courier;
import com.cm.entity.User;
import com.cm.repository.CourierRepository;
import com.cm.util.CourierStatus;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class CourierServiceImpl implements CourierService {

	@Autowired
	private CourierRepository courierRepo;

	@Override
	public Courier saveCourier(Courier courier) {
//		courier.setUser(User.getId());
		courier.setStatus(CourierStatus.In_PickedUp.name());
		Courier newCourier = courierRepo.save(courier);
		return newCourier;
	}

	@Override
	public List<Courier> getAllCourier() {

		return courierRepo.findAll();
	}

	@Override
	public Courier getCourierById(Integer courierId) {
		return courierRepo.findById(courierId).get();
	}

	@Override
	public boolean deleteCourier(Integer courierId) {
		Courier courier =courierRepo.findById(courierId).get();
		if (courier != null) {
			courierRepo.delete(courier);
			return true;
		}
		return false;
	}

	public void removeSessionMessage() {
		HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest()
				.getSession();

		session.removeAttribute("msg");

	}

	@Override
	public boolean updateCourierStatus(Integer id, String status) {
		Optional <Courier> findById=courierRepo.findById(id);
		if(findById.isPresent())
		{
			Courier courier=findById.get();
			courier.setStatus(status);
			courierRepo.save(courier);
			return true;
		}
		return false;
	}

	@Override
	public List<Courier> getCourierByUserId(Integer userId) {
		List<Courier> couriers=courierRepo.findByUserId(userId);
		return couriers;
	}

	
	@Override
	public Boolean updateOrderStatus(Integer id, String status) {
		Optional<Courier> findById = courierRepo.findById(id);
		if (findById.isPresent()) {
			Courier courier = findById.get();
			courier.setStatus(status);
			courierRepo.save(courier);
			return true;
		}
		return false;
	}
}