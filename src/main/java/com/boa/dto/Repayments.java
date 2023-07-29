package com.boa.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Repayments {

	private Date date;
	private BigDecimal incomeAfterExpense;
	private List<DebtPlan> debtPlans;
	
	public Repayments() {}
	
	public Repayments(Date date, BigDecimal incomeAfterExpense, String message, List<DebtPlan> debtPlans) {
		super();
		this.date = date;
		this.incomeAfterExpense = incomeAfterExpense;
		this.debtPlans = debtPlans;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public BigDecimal getIncomeAfterExpense() {
		return incomeAfterExpense;
	}
	public void setIncomeAfterExpense(BigDecimal incomeAfterExpense) {
		this.incomeAfterExpense = incomeAfterExpense;
	}
	
	public List<DebtPlan> getDebtPlans() {
		return debtPlans;
	}
	public void setDebtPlans(List<DebtPlan> debtPlans) {
		this.debtPlans = debtPlans;
	}
	
	
}
