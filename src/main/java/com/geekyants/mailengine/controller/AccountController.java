package com.geekyants.mailengine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geekyants.mailengine.dto.AccountRequestDto;
import com.geekyants.mailengine.exception.InValidCustomerException;
import com.geekyants.mailengine.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@PostMapping("/customers/accounts")
	public void accountCreation(AccountRequestDto accountRequestDto) throws InValidCustomerException {
		accountService.accountCreation(accountRequestDto);
	}
}
