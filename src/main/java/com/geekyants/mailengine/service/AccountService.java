package com.geekyants.mailengine.service;

import com.geekyants.mailengine.dto.AccountRequestDto;
import com.geekyants.mailengine.exception.InValidCustomerException;

public interface AccountService {
	
	public String accountCreation(AccountRequestDto accountRequestDto) throws InValidCustomerException;

}
