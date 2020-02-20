package com.geekyants.mailengine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.geekyants.mailengine.dto.CustomerRequestDto;
import com.geekyants.mailengine.dto.ResponseDto;
import com.geekyants.mailengine.exception.NoEntriesException;
import com.geekyants.mailengine.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping(value = "/customers")
	public ResponseDto customerRegistration(@RequestBody CustomerRequestDto customerRequestDto) throws NoEntriesException {
	    return	customerService.customerRegistration(customerRequestDto);
		
	}

	

}
