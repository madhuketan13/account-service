package com.dnb.accountservice.service;

import java.util.Optional;

import javax.naming.InvalidNameException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dnb.accountservice.dto.Account;
import com.dnb.accountservice.dto.Customer;
import com.dnb.accountservice.exceptions.IdNotFoundException;
import com.dnb.accountservice.exceptions.InvalidDateException;
import com.dnb.accountservice.repo.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountRepository accountRepository;
	
//	@Autowired
//	private ApiClient apiClient;
	
//	@Autowired
//	private CustomerRepository customerRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	@Value("${api.customer}")
	private String URL;

	@Override
	public Account createAccount(Account account) throws IdNotFoundException {
		
		try {
			ResponseEntity<Customer> responseEntity = restTemplate.getForEntity(URL+"/"+account.getCustomerId() , Customer.class);
			System.out.println("Response status "+responseEntity.getBody());
			//apiClient.getCustomerById(account.getCustomerId());
			return accountRepository.save(account);
		}
		catch (Exception e) {
			//System.out.println(e.getMessage());
			throw new IdNotFoundException("customer id not found");
		}
	}

	@Override
	public Optional<Account> getAccountById(String accountId) throws InvalidNameException, InvalidDateException {
		// TODO Auto-generated method stub
		return accountRepository.findById(accountId);
	}

	@Override
	public boolean deleteAccountById(String accountId) throws IdNotFoundException {
		
		if(accountRepository.existsById(accountId)) {
			accountRepository.deleteById(accountId);
			return true;
		}
		throw new IdNotFoundException("No accound found by the given id");
	}

	@Override
	public Iterable<Account> getAllAccounts() throws InvalidNameException, InvalidDateException {
		// TODO Auto-generated method stub
		return accountRepository.findAll();
	}

	@Override
	public boolean existsById(String accountId) {
		return accountRepository.existsById(accountId);
	}

	@Override
	public Optional<Account> findByContactNumber(String contactNumber) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

//	@Override
//	public Optional<Account> findByContactNumber(String contactNumber) {
//		// TODO Auto-generated method stub
//		return accountRepository.findByContactNumber(contactNumber);
//	}


   
}

