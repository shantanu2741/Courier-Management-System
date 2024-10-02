package com.cm.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cm.entity.Company;
import com.cm.entity.Courier;
import com.cm.entity.User;
import com.cm.repository.UserRepository;
import com.cm.service.CompanyService;
import com.cm.service.CourierService;
import com.cm.service.UserService;
import com.cm.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	
	@Autowired
	private UserService userService;
	

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
	public String showIndex()
	{
		return "index";
	}
	
	@GetMapping("/register")
	public String register()
	{
		return "register";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute User user,HttpSession session)
	{
		
		boolean f=userService.checkEmailAlreadyExist(user.getEmail());
		if(f)
		{
			session.setAttribute("msg","Email already exist");
		}
		else
		{
			User saveUser=userService.saveUser(user);
			if(saveUser!=null)
			{
				session.setAttribute("msg","User saved successfully");
			}
			else
			{
				session.setAttribute("msg","Failed  ");
			}
		}
		return "redirect:register";
	}
	
	@GetMapping("/signIn")
	public String login()
	{
		return "login";
	}
	
	
	
	
//	<th:block th:if="${session.msg}">
//	<p>[[${session.msg}]]</p>
//	<th:block th:text="${@CourierServiceImpl.removeSessionMessage()}"></th:block>
//</th:block>
//	Courier Description : <input type="text" name="courierDescription" 
//	        th:value="${courier.courierDescription}" /><br/><br/>
//	        Courier Weight : <input type="text" name="courierWeight" 
//	        th:value="${courier.courierWeight}" /><br /><br />
//	        Courier Dimensions : <input type="text" name="courierDimensions" 
//	        th:value="${courier.courierDimensions}" /><br/><br/>
//	        Courier Type : <input type="text" name="courierType" 
//	        th:value="${courier.courierType}" /><br/><br/>
	
	//user register
//	<th:block th:if="${session.msg}">
//	<p>[[${session.msg}]]</p>
//	<th:block th:text="${@userServiceImpl.removeSessionMessage()}"></th:block>
//</th:block>
		@Autowired CompanyService companyService;
		
		@GetMapping("/saveCompanyy")
		public String saveCompanyy()
		{
			return "addCompany";
		}
		@PostMapping("/saveCompany")
		public String saveCompany(@ModelAttribute Company company,
		                                @RequestParam("adminName") String adminName,
		                                @RequestParam("adminEmail") String adminEmail,
		                                @RequestParam("adminPassword") String adminPassword,
		                                Model model) {

			    Company comm=companyService.saveCompany(company, adminName, adminEmail, adminPassword);
		        model.addAttribute("message", "Company and Admin created successfully!");
				return "login";
		}
		
		@PostMapping("/companyLoginHere")
		public String companyLoginHere()
		{
			return "companyLogin";
		}

}
