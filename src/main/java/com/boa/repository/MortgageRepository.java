package com.boa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boa.model.Mortgage;
import com.boa.model.VehicleLoan;

@Repository
public interface MortgageRepository extends CrudRepository<Mortgage, Integer>{

	List<Mortgage> findBySsn(String ssn);

}
