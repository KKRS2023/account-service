package com.boa.dto;

import java.util.List;

public class Plan {

	private String message;
	private List<Repayments> repayments;
	
	
	public Plan() {}
	
	public Plan(String message, List<Repayments> repayments) {
		super();
		this.message = message;
		this.repayments = repayments;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Repayments> getRepayments() {
		return repayments;
	}
	public void setRepayments(List<Repayments> repayments) {
		this.repayments = repayments;
	}
	
	
}
