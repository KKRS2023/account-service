package com.boa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boa.model.CreditCard;

@Repository
public interface CreditCardRepository extends CrudRepository<CreditCard, String> {

	List<CreditCard> findBySsn(String ssn);

}
