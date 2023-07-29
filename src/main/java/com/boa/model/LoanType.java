package com.boa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the loan_type database table.
 * 
 */
@Entity
@Table(name="loan_type")
@NamedQuery(name="LoanType.findAll", query="SELECT l FROM LoanType l")
public class LoanType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String type;

	@Column(name="INTEREST_RATES")
	private BigDecimal interestRates;

	public LoanType() {
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getInterestRates() {
		return this.interestRates;
	}

	public void setInterestRates(BigDecimal interestRates) {
		this.interestRates = interestRates;
	}

}