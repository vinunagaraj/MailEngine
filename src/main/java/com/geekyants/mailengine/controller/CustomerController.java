package com.geekyants.mailengine.controller;

import java.util.Locale;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.geekyants.mailengine.dto.CustomerRequestDto;
import com.geekyants.mailengine.dto.EmailDto;
import com.geekyants.mailengine.dto.ResponseDto;
import com.geekyants.mailengine.exception.NoEntriesException;
import com.geekyants.mailengine.exception.NotFoundException;
import com.geekyants.mailengine.service.CustomerService;
import com.geekyants.mailengine.service.EmailService;

/*
 * Controller class for customer creation
 */
@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@Autowired
	private EmailService emailService;

	/**
	 * @author Vinod B N
	 * @author Karthika T
	 * @author Raghib
	 * 
	 * @param customerRequestDto
	 * @return ResponseDto of statusCode and message
	 * @throws NoEntriesException
	 */
	@PostMapping(value = "/customers")
	public ResponseDto customerRegistration(@RequestBody CustomerRequestDto customerRequestDto)
			throws NoEntriesException {
		return customerService.customerRegistration(customerRequestDto);

	}

	@PostMapping("/mails")
	public String sendMail(@RequestBody EmailDto emailDto) throws MessagingException, NotFoundException {

		Locale locale = new Locale("EN", "INDIA");

		emailService.sendMailForCustomerCreation(emailDto, locale);

		return "email sent";
	}

}
