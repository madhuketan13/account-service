package com.dnb.accountservice.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dnb.accountservice.dto.Account;
import com.google.common.base.Optional;

@Repository
public interface AccountRepository extends CrudRepository<Account, String>{
	
	public Optional<Account> findByContactNumber(String contactNumber);

}
