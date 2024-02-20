package com.spring.banking.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.banking.dao.BankDAO;
import com.spring.banking.dto.User;

@RestController
@RequestMapping("/api")
public class BankController {

	@PostMapping("/login")
	public User checkCredintials(@RequestParam(name="name") String userName,@RequestParam(name="pass") String userPass) {
		
	 BankDAO dao = new BankDAO();
		return  dao.checkCredintials(userName, userPass);
		
	}	
	
	@PostMapping("/register")
	public User registerDetails(@RequestBody User dto) {
		
		BankDAO dao = new BankDAO();
		dao.registerDetails(dto);
		
		return dto;
	}
}
	

