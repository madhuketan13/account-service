package com.dnb.accountservice.service;

import java.util.Optional;

import javax.naming.InvalidNameException;

import com.dnb.accountservice.dto.Account;
import com.dnb.accountservice.exceptions.IdNotFoundException;
import com.dnb.accountservice.exceptions.InvalidDateException;

public interface AccountService {

    public Account createAccount(Account account) throws IdNotFoundException;

    public Optional<Account> getAccountById(String accountId) throws InvalidNameException, InvalidDateException;

    public boolean deleteAccountById(String accountId) throws IdNotFoundException;

    public Iterable<Account> getAllAccounts() throws InvalidNameException, InvalidDateException;
    
    public boolean existsById(String accountId);
    
    public Optional<Account> findByContactNumber(String contactNumber);
}
