package com.boa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boa.dto.AccountDTO;
import com.boa.dto.Plan;
import com.boa.service.RepaymentService;

@RestController
@RequestMapping("/repay/v1/")
@CrossOrigin("*")
public class RepaymentController {

	@Autowired
	private RepaymentService repaymentService;
	
	@PostMapping("/plan")
	public ResponseEntity<Plan> calculatePlan(@RequestBody AccountDTO acc){
		Plan plan = repaymentService.calculateRepayments(acc);
		return new ResponseEntity<>(plan, HttpStatus.OK);
	}
}
