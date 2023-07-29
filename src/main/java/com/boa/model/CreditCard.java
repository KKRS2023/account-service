package com.boa.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the credit_cards database table.
 * 
 */
@Entity
@Table(name="credit_cards")
@NamedQuery(name="CreditCard.findAll", query="SELECT c FROM CreditCard c")
public class CreditCard implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CARD_NUMBER")
	private String cardNumber;

	@Column(name="ACCOUNT_NUMBER")
	private int accountNumber;

	@Column(name="CARD_LIMIT")
	private int cardLimit;

	@Column(name="SSN")
	private String ssn;

	@Column(name="USED_LIMIT")
	private int usedLimit;

	public CreditCard() {
	}

	public String getCardNumber() {
		return this.cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getCardLimit() {
		return this.cardLimit;
	}

	public void setCardLimit(int cardLimit) {
		this.cardLimit = cardLimit;
	}

	public String getSsn() {
		return this.ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public int getUsedLimit() {
		return this.usedLimit;
	}

	public void setUsedLimit(int usedLimit) {
		this.usedLimit = usedLimit;
	}

}