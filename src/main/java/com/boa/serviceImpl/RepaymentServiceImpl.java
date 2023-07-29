package com.boa.serviceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boa.constant.Constants;
import com.boa.dto.AccountDTO;
import com.boa.dto.Debt;
import com.boa.dto.DebtPlan;
import com.boa.dto.Plan;
import com.boa.dto.Repayments;
import com.boa.model.LoanType;
import com.boa.repository.LoanTypeRepository;
import com.boa.service.RepaymentService;

@Service
public class RepaymentServiceImpl implements RepaymentService {

	@Autowired
	private LoanTypeRepository loanTypeRepository;

	@Override
	public Plan calculateRepayments(AccountDTO acc) {
		Plan p = new Plan();
		BigDecimal fixedEmi = BigDecimal.ZERO;
		List<Debt> debts = acc.getDebts();

		if (debts == null || debts.size() < 1) {
			p.setMessage(Constants.NO_DEBT);
		} else {
			fixedEmi = debts.stream().map(x -> x.getEmi()).reduce((x, y) -> x.add(y)).orElse(BigDecimal.ZERO);
			if (acc.getIncome().compareTo(acc.getExpense()) < 1) {
				p.setMessage(Constants.NEGATIVEINCOME);
			} else if (acc.getIncome().add(fixedEmi).compareTo(acc.getExpense()) < 1) {
				p.setMessage(Constants.MANDATORYEMI);
			} else {
				List<Repayments> repayments = calculatePlan(acc, fixedEmi);
				p.setMessage("PLAN Generated");
				p.setRepayments(repayments);
			}
		}

		return p;
	}

	private List<Repayments> calculatePlan(AccountDTO acc, BigDecimal fixedEmi) {
		List<Repayments> repayments = new ArrayList<Repayments>();
		List<LoanType> loanTypes = loanTypeRepository.findTop10ByOrderByInterestRatesDesc();
		List<Debt> debts = new ArrayList<>();
		for (LoanType loanType : loanTypes) {
			String type = loanType.getType();
			for (Debt debt : acc.getDebts()) {
				if(type.equalsIgnoreCase(debt.getDebtType())) {
					debts.add(debt);
				}
				
			}
		}

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		Date lastDay = calendar.getTime();
		BigDecimal income = acc.getIncome();
		BigDecimal expense = acc.getExpense();
		BigDecimal incomeAfterExpense = income.subtract(expense);
		BigDecimal balanceAfterEmi = incomeAfterExpense.subtract(fixedEmi);
		while (debts.size() > 0 && incomeAfterExpense.compareTo(BigDecimal.ZERO) >= 1) {
			Repayments repayment = new Repayments();
			repayment.setDate(lastDay);
			repayment.setIncomeAfterExpense(incomeAfterExpense);
			List<DebtPlan> debtPlan = new ArrayList<>();
			for (Debt debt : debts) {
				DebtPlan dp = new DebtPlan();
				dp.setEmi(debt.getEmi());
				dp.setDebtType(debt.getDebtType());
				dp.setDebtRemaining(debt.getAmount());
				if (debt.getAmount().doubleValue() < debt.getEmi().doubleValue()) {
					balanceAfterEmi = balanceAfterEmi.add(debt.getEmi().subtract(debt.getAmount()));
					debt.setAmount(BigDecimal.ZERO);
					debt.setEmi(BigDecimal.ZERO);
					dp.setAdditionalPayment(BigDecimal.ZERO);
				} else if (debt.getAmount().compareTo(debt.getEmi().add(balanceAfterEmi)) < 1) {
					balanceAfterEmi = balanceAfterEmi
							.add((debt.getEmi().add(balanceAfterEmi)).subtract(debt.getAmount()));
					dp.setAdditionalPayment((debt.getEmi().add(balanceAfterEmi)).subtract(debt.getAmount()));
					debt.setAmount(BigDecimal.ZERO);
					debt.setEmi(BigDecimal.ZERO);

				} else {
					debt.setAmount(debt.getAmount().subtract(balanceAfterEmi.add(debt.getEmi())));
					dp.setAdditionalPayment(balanceAfterEmi);
					balanceAfterEmi = BigDecimal.ZERO;
				}
				dp.setRemainingDebt(debt.getAmount());
				debtPlan.add(dp);
			}
			repayment.setDebtPlans(debtPlan);
			// For Next Monthe
			calendar.add(Calendar.MONTH, 1);
			calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
			lastDay = calendar.getTime();

			if (lastDay.getMonth() == 3 && (acc.getIncreaseInIncome() > 0 || acc.getIncreateInExpense() > 0)) {
				if (acc.getIncreaseInIncome() > 0) {
					income = income.add((income.multiply(new BigDecimal(acc.getIncreaseInIncome() / 100))));
				}
				if (acc.getIncreateInExpense() > 0) {
					expense = expense.add((expense.multiply(new BigDecimal(acc.getIncreateInExpense() / 100))));
				}
				incomeAfterExpense = income.subtract(expense);
			}
			fixedEmi = debts.stream().map(x -> x.getEmi()).reduce((x, y) -> x.add(y)).orElse(BigDecimal.ZERO);
			debts = debts.stream().filter(x -> (x.getAmount().compareTo(BigDecimal.ZERO) >= 1))
					.collect(Collectors.toList());
			balanceAfterEmi = incomeAfterExpense.subtract(fixedEmi);
			repayments.add(repayment);
		}

		return repayments;
	}

}
