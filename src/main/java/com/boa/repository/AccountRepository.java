package com.boa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boa.model.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer>{

}
