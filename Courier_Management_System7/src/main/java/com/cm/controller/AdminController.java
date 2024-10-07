
package com.cm.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cm.entity.Courier;
import com.cm.entity.User;
import com.cm.repository.UserRepository;
import com.cm.service.CourierService;
import com.cm.util.CourierStatus;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UserRepository userRepo;
	
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
	@GetMapping("/")
	public String profile()
	{
		return "admin/admin_profile";
	}
	
	@Autowired
	private CourierService courierService;

	@GetMapping("/loadCourierSave")
	public String loadCourierSave(Model m) {
		List<Courier> list = courierService.getAllCourier();
		m.addAttribute("courierList", list);
		return "admin/viewCouriers";
	}
	
	@PostMapping("/update-courier-status")
	public String updateOrderStatus(@RequestParam("id") Integer id, @RequestParam("st") Integer st,Session session)
	{
		CourierStatus[] values = CourierStatus.values();
		String status = null;

		for (CourierStatus courierSt : values) {
			if (courierSt.getId().equals(st)) {
				status = courierSt.getName();
			}
		}
		
		Boolean updateCourier = courierService.updateCourierStatus(id, status);
		
		
		return "redirect:/admin/loadCourierSave";
	}
	
	@GetMapping("/update-status")
	public String updateOrderStatus(@RequestParam Integer id,@RequestParam Integer st)
	{
		CourierStatus[] values=CourierStatus.values();
		System.out.println("Values:"+values);
		return "redirect:/admin/loadCourierSave";
	}
}
