package com.boa.service;

import com.boa.dto.AccountDTO;
import com.boa.dto.Plan;

public interface RepaymentService {

	public Plan calculateRepayments(AccountDTO acc);
}
