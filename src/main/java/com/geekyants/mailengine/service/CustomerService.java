package com.geekyants.mailengine.service;

import com.geekyants.mailengine.dto.CustomerRequestDto;
import com.geekyants.mailengine.dto.ResponseDto;
import com.geekyants.mailengine.exception.NoEntriesException;

public interface CustomerService {

	public ResponseDto customerRegistration(CustomerRequestDto customerRequestDto) throws NoEntriesException;
	
	

}
