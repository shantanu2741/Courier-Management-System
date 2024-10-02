package com.cm.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cm.entity.Courier;
import com.cm.entity.User;
import com.cm.repository.UserRepository;
import com.cm.service.CourierService;
import com.cm.service.UserService;
import com.cm.util.CourierStatus;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserService userService;
	
	@ModelAttribute()
	public void commonUser(Principal p, Model m)
	{
		if(p!=null)                                                                                                    
		{
			String email=p.getName();
			User user=userRepo.findByEmail(email);
			m.addAttribute("user",user);
		}
	}
	
	private User getLoggedInUserDetails(Principal p) {
		String email = p.getName();
		User user = userService.getUserByEmail(email);

		return user;
	}
	
	@GetMapping("/")
	public String profile()
	{
		return "user/profile";
	}
	
	@GetMapping("/update-status")
	public String updateOrderStatus(@RequestParam Integer id,@RequestParam Integer st,Session session)
	{
		CourierStatus[] values = CourierStatus.values();
		String status = null;

		for (CourierStatus courierSt : values) {
			if (courierSt.getId().equals(st)) {
				status = courierSt.getName();
			}
		}
		
		Boolean updateCourier = courierService.updateCourierStatus(id, status);
		
		
		return "redirect:/user/loadCourierSave";
	}
	
	@GetMapping("/addCourier")
	public String addCourier()
	{
		return "user/addCourier";
	}
	
//	@GetMapping("/loadCourierSave")
//	public String loadCourierSave(Model m) {
//		List<Courier> list = courierService.getAllCourier();
//		m.addAttribute("courierList", list);
//		return "user/viewCourier";
//	}
	
	@Autowired
	private CourierService courierService;

	@GetMapping("/loadCourierSave")
	public String loadCourierSave(Model m,Principal p) {
		  
		User loginUser= getLoggedInUserDetails(p);
		List<Courier>couriers=courierService.getCourierByUserId(loginUser.getId());
		m.addAttribute("couriers",couriers);
		return "user/viewCourier";
	}

	
//	@GetMapping("/loadCourierSave")
//	public String loadCourierSave() {
//		return "viewCourier";
//	}

	@GetMapping("/EditCourier/{courierId}")
	public String EditCourier(@PathVariable Integer courierId, Model m) {
		Courier courier = courierService.getCourierById(courierId);
		m.addAttribute("courier", courier);
		return "user/updateCourier";
	}
	
	@PostMapping("/addCourierHere")
	public String saveCourier(@ModelAttribute Courier courier,Principal principal, HttpSession session) {
		User loggedInUser = getLoggedInUserDetails(principal);
		courier.setUser(loggedInUser);

		Courier newCourier = courierService.saveCourier(courier);

		if (newCourier != null) {
			session.setAttribute("msg", "Added sucessfully");
		} else {
			session.setAttribute("msg", "something wrong on server");
		}

		return "redirect:/user/loadCourierSave";
	}

	@PostMapping("/updateCourierDtls")
	public String updateCourier(@ModelAttribute Courier courier, HttpSession session) {

		Courier updateCourier = courierService.saveCourier(courier);

		if (updateCourier != null) {
			session.setAttribute("msg", "Update sucessfully");
		} else {
			session.setAttribute("msg", "something wrong on server");
		}

		return "redirect:/user/loadCourierSave";
	}



	@GetMapping("/deleteCourier/{courierId}")
	public String loadCourierSave(@PathVariable int courierId, HttpSession session) {
		boolean f = courierService.deleteCourier(courierId);
		if (f) {
			session.setAttribute("msg", "Delete sucessfully");
		} else {
			session.setAttribute("msg", "something wrong on server");
		} 
		return "redirect:/user/loadCourierSave";
	}
}
