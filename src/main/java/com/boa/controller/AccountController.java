package com.boa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boa.dto.AccountDTO;
import com.boa.service.AccountService;

@RestController
@RequestMapping("/account/v1/")
@CrossOrigin("*")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@GetMapping("/{accountNo}")
	public ResponseEntity<AccountDTO> getAccountData(@PathVariable int accountNo) {
		AccountDTO accountDTO = accountService.getDetails(accountNo);
		return new ResponseEntity<AccountDTO>(accountDTO, HttpStatus.OK);		
	}
}
