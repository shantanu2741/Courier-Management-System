//package com.cm.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.cm.entity.Company;
//import com.cm.entity.User;
//import com.cm.repository.CompanyRepository;
//import com.cm.repository.UserRepository;
//@Service
//public class CompanyServiceImpl implements CompanyService{
//	
//	@Autowired 
//	CompanyRepository companyRepository;
//	
//	@Autowired
//    private UserRepository userRepository;
//	
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder; 
//	
//	public Company saveCompany(Company company, String adminName, String adminEmail, String adminPassword)
//	{		
//		Company com=companyRepository.save(company);
//
//		User adminUser = new User();
//	    adminUser.setName(adminName);
//	    adminUser.setEmail(adminEmail);
//
//		
//	    String encodedPassword = passwordEncoder.encode(adminPassword);
//	    adminUser.setPassword(encodedPassword);
//	    adminUser.setRole("ROLE_ADMIN");
//	    adminUser.setCompany(com); 
//	    adminUser.setAddress(company.getCompanyAddress()); 
//
//	    userRepository.save(adminUser);
//		return com;
//	}
//
//
//	
//	
//
//}
package com.cm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cm.entity.Company;
import com.cm.entity.User;
import com.cm.repository.CompanyRepository;
import com.cm.repository.UserRepository;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired 
    private CompanyRepository companyRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder; 

    @Override
    public Company saveCompany(Company company, String adminName, String adminEmail, String adminPassword) {
        if (userRepository.existsByEmail(adminEmail)) {
            System.out.println("User with email " + adminEmail + " already exists.");
            return null; 
        }

        Company com = companyRepository.save(company);

        User adminUser = new User();
        adminUser.setName(adminName);
        adminUser.setEmail(adminEmail);

        String encodedPassword = passwordEncoder.encode(adminPassword);
        adminUser.setPassword(encodedPassword);  // Set the encoded password

        adminUser.setRole("ROLE_ADMIN");
        adminUser.setCompany(com);
        adminUser.setAddress(company.getCompanyAddress());

        userRepository.save(adminUser);

        return com; 
    }
}
