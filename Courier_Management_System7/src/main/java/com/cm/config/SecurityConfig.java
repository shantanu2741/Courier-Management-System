package com.cm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	public CustomAuthSuccessHandler successHandler;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService getDetailsService()
	{
		return new CustomUserDetailsService();
	}
	
	@Bean 
	public DaoAuthenticationProvider getAuthenticationProvider()
	{
		DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(getDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		return daoAuthenticationProvider;
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
//		 http.csrf().disable()
//		.authorizeHttpRequests().requestMatchers("/","/register","/signIn","/registerHere").permitAll()
//		.requestMatchers("/user/**").authenticated().and()
//		.formLogin().loginPage("/signIn").loginProcessingUrl("/userLogin")
//		.defaultSuccessUrl("/user/**")
//		.permitAll();
		
//		http.csrf().disable()
//		.authorizeHttpRequests().requestMatchers("/user/**").hasRole("user")
//		.requestMatchers("/admin/**").hasRole("admin")
//		.requestMatchers("/**","/","/register","/signIn","/registerHere").permitAll().and()
//		.formLogin().loginPage("/signIn").loginProcessingUrl("/**")
//		.successHandler(successHandler)
//		.and().logout().permitAll();
		
		
		http.csrf(csrf->csrf.disable()).cors(cors->cors.disable())
		.authorizeHttpRequests(req->req.requestMatchers("/user/**").hasRole("USER")
				.requestMatchers("/admin/**").hasRole("ADMIN")
				.requestMatchers("/**").permitAll())
				.formLogin(form->form.loginPage("/signIn")
						.loginProcessingUrl("/login")
						.successHandler(successHandler))
				.logout(logout->logout.permitAll());
		return http.build(); 
	}
}

