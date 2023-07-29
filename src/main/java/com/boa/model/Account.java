package com.boa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the accounts database table.
 * 
 */
@Entity
@Table(name="accounts")
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ACCOUNT_NUMBER")
	private int accountNumber;

	@Temporal(TemporalType.DATE)
	private Date dob;

	private BigDecimal expense;

	private BigDecimal income;

	@Column(name="INCREASE_IN_INCOME")
	private int increaseInIncome;

	@Column(name="INCREATE_IN_EXPENSE")
	private int increateInExpense;

	private String name;

	private String ssn;

	public Account() {
	}

	public int getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public BigDecimal getExpense() {
		return this.expense;
	}

	public void setExpense(BigDecimal expense) {
		this.expense = expense;
	}

	public BigDecimal getIncome() {
		return this.income;
	}

	public void setIncome(BigDecimal income) {
		this.income = income;
	}

	public int getIncreaseInIncome() {
		return this.increaseInIncome;
	}

	public void setIncreaseInIncome(int increaseInIncome) {
		this.increaseInIncome = increaseInIncome;
	}

	public int getIncreateInExpense() {
		return this.increateInExpense;
	}

	public void setIncreateInExpense(int increateInExpense) {
		this.increateInExpense = increateInExpense;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSsn() {
		return this.ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

}