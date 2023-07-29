package com.boa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the mortgage database table.
 * 
 */
@Entity
@NamedQuery(name="Mortgage.findAll", query="SELECT m FROM Mortgage m")
public class Mortgage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MORTGAGE_ID")
	private int mortgageId;

	@Column(name="ACCOUNT_NUMBER")
	private int accountNumber;

	@Column(name="CURRENT_LOAN")
	private BigDecimal currentLoan;

	private BigDecimal emi;

	@Column(name="LOAN_AMOUNT")
	private BigDecimal loanAmount;

	private String ssn;

	@Temporal(TemporalType.DATE)
	@Column(name="STAR_DATE")
	private Date starDate;

	@Column(name="TOTAL_TENURE")
	private int totalTenure;

	public Mortgage() {
	}

	public int getMortgageId() {
		return this.mortgageId;
	}

	public void setMortgageId(int mortgageId) {
		this.mortgageId = mortgageId;
	}

	public int getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BigDecimal getCurrentLoan() {
		return this.currentLoan;
	}

	public void setCurrentLoan(BigDecimal currentLoan) {
		this.currentLoan = currentLoan;
	}

	public BigDecimal getEmi() {
		return this.emi;
	}

	public void setEmi(BigDecimal emi) {
		this.emi = emi;
	}

	public BigDecimal getLoanAmount() {
		return this.loanAmount;
	}

	public void setLoanAmount(BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getSsn() {
		return this.ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public Date getStarDate() {
		return this.starDate;
	}

	public void setStarDate(Date starDate) {
		this.starDate = starDate;
	}

	public int getTotalTenure() {
		return this.totalTenure;
	}

	public void setTotalTenure(int totalTenure) {
		this.totalTenure = totalTenure;
	}

}