package com.spring.banking.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.banking.dao.BankDAO;
import com.spring.banking.dto.Account;
import com.spring.banking.dto.Transaction;
import com.spring.banking.dto.User;

@RestController
@RequestMapping("/api")
public class BankController {
	BankDAO dao = new BankDAO();

	@PostMapping("/login")
	public User checkCredintials(@RequestParam(name = "uname") String userName,
			@RequestParam(name = "pass") String userPass) {
		return dao.checkCredintials(userName, userPass);

	}

	@PostMapping("/register")
	public User registerDetails(@RequestBody User dto) {
		dao.registerDetails(dto);
		return dto;
	}

	@PostMapping("/add/acc")
	public Account addAccountDetails(@RequestBody Account acc) {
		dao.setAccDetails(acc);
		return acc;
	}

	@PostMapping("/get/acc")
	public List<Account> getAccountDetails(@RequestParam(name = "id") int id) {
		return dao.getAccDetails(id);

	}

	@PostMapping("/trxns")
	public Transaction setTrxns(@RequestBody Transaction trxn) {
		dao.setTransactionDetails(trxn);
		return trxn;
	}
}
	

