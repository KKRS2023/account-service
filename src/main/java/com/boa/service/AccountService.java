package com.boa.service;

import org.springframework.stereotype.Service;

import com.boa.dto.AccountDTO;

@Service
public interface AccountService {

	public AccountDTO getDetails(int accountNumber);
}
