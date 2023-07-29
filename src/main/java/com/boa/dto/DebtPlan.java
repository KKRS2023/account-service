package com.boa.dto;

import java.math.BigDecimal;

public class DebtPlan {

	private String debtType;
	private BigDecimal remainingDebt;
	private BigDecimal emi;
	private BigDecimal additionalPayment;
	private BigDecimal debtRemaining;
	
	public DebtPlan() {}
	
	public DebtPlan(String debtType, BigDecimal remainingDebt, BigDecimal emi, BigDecimal additionalPayment,
			BigDecimal debtRemaining) {
		super();
		this.debtType = debtType;
		this.remainingDebt = remainingDebt;
		this.emi = emi;
		this.additionalPayment = additionalPayment;
		this.debtRemaining = debtRemaining;
	}
	
	public String getDebtType() {
		return debtType;
	}
	public void setDebtType(String debtType) {
		this.debtType = debtType;
	}
	public BigDecimal getRemainingDebt() {
		return remainingDebt;
	}
	public void setRemainingDebt(BigDecimal remainingDebt) {
		this.remainingDebt = remainingDebt;
	}
	public BigDecimal getEmi() {
		return emi;
	}
	public void setEmi(BigDecimal emi) {
		this.emi = emi;
	}
	public BigDecimal getAdditionalPayment() {
		return additionalPayment;
	}
	public void setAdditionalPayment(BigDecimal additionalPayment) {
		this.additionalPayment = additionalPayment;
	}
	public BigDecimal getDebtRemaining() {
		return debtRemaining;
	}
	public void setDebtRemaining(BigDecimal debtRemaining) {
		this.debtRemaining = debtRemaining;
	}

	
}
