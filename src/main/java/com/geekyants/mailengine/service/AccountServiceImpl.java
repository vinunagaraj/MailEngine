package com.geekyants.mailengine.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geekyants.mailengine.constant.ApplicationConstant;
import com.geekyants.mailengine.dto.AccountRequestDto;
import com.geekyants.mailengine.entity.Account;
import com.geekyants.mailengine.entity.Customer;
import com.geekyants.mailengine.exception.InValidCustomerException;
import com.geekyants.mailengine.repository.AccountRepository;
import com.geekyants.mailengine.repository.CustomerRepository;
import com.geekyants.mailengine.util.Validation;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public String accountCreation(AccountRequestDto accountRequestDto) throws InValidCustomerException {
		Long customerId = accountRequestDto.getCustomerId();
		Optional<Customer> customer = customerRepository.findById(customerId);
		if(!customer.isPresent()) {
			throw new InValidCustomerException(ApplicationConstant.CUSTOMER_NOT_FOUND);
		}
		int accountNumber = Validation.generatePin();
		Account account = new Account();
		account.setAccountNumber(accountNumber);
		account.setAccountType(ApplicationConstant.SAVINGS);
		account.setBalance(ApplicationConstant.MINIMUM_BALANCE);
		account.setBankName(ApplicationConstant.ABC_BANK);
		accountRepository.save(account);
		return ApplicationConstant.ACCOUNT_CREATED_SUCCESSFULLY;
	}
}
