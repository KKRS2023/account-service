package com.boa.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boa.dto.AccountDTO;
import com.boa.dto.Debt;
import com.boa.model.Account;
import com.boa.model.CreditCard;
import com.boa.model.Mortgage;
import com.boa.model.VehicleLoan;
import com.boa.repository.AccountRepository;
import com.boa.repository.CreditCardRepository;
import com.boa.repository.MortgageRepository;
import com.boa.repository.VehicleLoanRepository;
import com.boa.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private CreditCardRepository creditCardRepository;
	
	@Autowired
	private VehicleLoanRepository vehicleLoanRepository;
	
	@Autowired
	private MortgageRepository mortgageRepository;
	
	public AccountDTO getDetails(int accountNo) {
		AccountDTO accountDto = null;
		Account account = accountRepository.findById(accountNo).orElse(null);
		if(account == null) {
			return accountDto;
		}else {
			List<Debt> debts = evaluateDebts(account);
			accountDto = new AccountDTO(account, debts);
		}
		return accountDto;
	}

	private List<Debt> evaluateDebts(Account account) {
		List<Debt> debts = new ArrayList<Debt>();
		List<VehicleLoan> vehicleLoans = vehicleLoanRepository.findBySsn(account.getSsn());
		List<Mortgage> mortgages = mortgageRepository.findBySsn(account.getSsn());
		List<CreditCard> creditcards = creditCardRepository.findBySsn(account.getSsn());
		
		if(vehicleLoans != null && vehicleLoans.size() > 0) {
			for (VehicleLoan loan : vehicleLoans) {
				if(loan.getCurrentLoan().intValue() > 0) {
					debts.add(new Debt(loan));
				}
			}
		}
		
		if(mortgages != null && mortgages.size() > 0) {
			for (Mortgage loan : mortgages) {
				if(loan.getCurrentLoan().intValue() > 0) {
					debts.add(new Debt(loan));
				}
			}
		}
		
		if(creditcards != null && creditcards.size() > 0) {
			for (CreditCard loan : creditcards) {
				if(loan.getUsedLimit() > 0) {
					debts.add(new Debt(loan));
				}
			}
		}
		
		return debts;
	}
}
