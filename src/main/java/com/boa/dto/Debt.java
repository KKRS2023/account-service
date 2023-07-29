package com.boa.dto;

import java.math.BigDecimal;

import com.boa.model.CreditCard;
import com.boa.model.Mortgage;
import com.boa.model.VehicleLoan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Debt {

	String debtType;
	BigDecimal amount;
	BigDecimal emi;
	int tenure;
	
	public String getDebtType() {
		return debtType;
	}
	public void setDebtType(String debtType) {
		this.debtType = debtType;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public BigDecimal getEmi() {
		return emi;
	}
	public void setEmi(BigDecimal emi) {
		this.emi = emi;
	}
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	public Debt(String debtType, BigDecimal amount, BigDecimal emi, int tenure) {
		super();
		this.debtType = debtType;
		this.amount = amount;
		this.emi = emi;
		this.tenure = tenure;
	}
	
	public Debt(VehicleLoan v) {
		super();
		this.debtType = "VEHICLE";
		this.amount = v.getCurrentLoan();
		this.emi = v.getEmi();
		this.tenure = v.getTotalTenure();
	}
	
	public Debt(Mortgage m) {
		super();
		this.debtType = "MORTGAGE";
		this.amount = m.getCurrentLoan();
		this.emi = m.getEmi();
		this.tenure = m.getTotalTenure();
	}
	
	public Debt(CreditCard c) {
		super();
		this.debtType = "CREDITCARD";
		this.amount = new BigDecimal(c.getUsedLimit());
		this.emi = BigDecimal.ZERO;
		this.tenure = 0;
	}
	
	
	
	public Debt() {}
	
}
