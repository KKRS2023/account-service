package com.boa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boa.model.LoanType;

@Repository
public interface LoanTypeRepository extends CrudRepository<LoanType, String>{
	List<LoanType> findTop10ByOrderByInterestRatesDesc();

}
