package com.boa.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.boa.model.Account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AccountDTO {

	int accountNumber;
	String name;
	String ssn;
	Date DOB;
	BigDecimal expense;
	BigDecimal income;
	int increaseInIncome;
	int increateInExpense;
	List<Debt> debts;
	
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public BigDecimal getExpense() {
		return expense;
	}
	public void setExpense(BigDecimal expense) {
		this.expense = expense;
	}
	public BigDecimal getIncome() {
		return income;
	}
	public void setIncome(BigDecimal income) {
		this.income = income;
	}
	public int getIncreaseInIncome() {
		return increaseInIncome;
	}
	public void setIncreaseInIncome(int increaseInIncome) {
		this.increaseInIncome = increaseInIncome;
	}
	public int getIncreateInExpense() {
		return increateInExpense;
	}
	public void setIncreateInExpense(int increateInExpense) {
		this.increateInExpense = increateInExpense;
	}
	public List<Debt> getDebts() {
		return debts;
	}
	public void setDebts(List<Debt> debts) {
		this.debts = debts;
	}
	public AccountDTO(Account account, List<Debt> debts) {
		super();
		this.accountNumber = account.getAccountNumber();
		this.name = account.getName();
		this.ssn = account.getSsn();
		DOB = account.getDob();
		this.expense = account.getExpense();
		this.income = account.getIncome();
		this.increaseInIncome = account.getIncreaseInIncome();
		this.increateInExpense = account.getIncreateInExpense();
		this.debts = debts;
	}
	
	public AccountDTO() {}

}
