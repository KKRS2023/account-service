package com.boa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boa.model.VehicleLoan;

@Repository
public interface VehicleLoanRepository extends CrudRepository<VehicleLoan, Integer>{

	List<VehicleLoan> findBySsn(String ssn);

}
