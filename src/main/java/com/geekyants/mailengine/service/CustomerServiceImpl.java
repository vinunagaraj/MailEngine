package com.geekyants.mailengine.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import com.geekyants.mailengine.constant.ApplicationConstant;
import com.geekyants.mailengine.dto.CustomerRequestDto;
import com.geekyants.mailengine.dto.EmailDto;
import com.geekyants.mailengine.dto.ResponseDto;
import com.geekyants.mailengine.entity.Customer;
import com.geekyants.mailengine.exception.NoEntriesException;
import com.geekyants.mailengine.repository.CustomerRepository;
/*
 * Method to Register customer
 */
@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository customerRepository;
	/**
	 * @author Vinod B N
	 * @author Raghib
	 * @author Karthika
	 * 
	 * @param customerRequestDto
	 * @return ResponseDto
 	 **/
	@Override
	public ResponseDto customerRegistration(CustomerRequestDto customerRequestDto) throws NoEntriesException {
		if(ObjectUtils.isEmpty(customerRequestDto)) {
			throw new NoEntriesException(ApplicationConstant.EMPTY_ENTRIES);
		}
			Customer customer = new Customer();
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers= new HttpHeaders();
			
			customer.setStatus(ApplicationConstant.ACTIVE);
			BeanUtils.copyProperties(customerRequestDto, customer);
			Customer registredCustomer = customerRepository.save(customer);
			EmailDto emailDto = new EmailDto();
			emailDto.setCustomerId(registredCustomer.getCustomerId());
			emailDto.setPurpose(ApplicationConstant.CUSTOMER_CREATION);
			HttpEntity ent= new HttpEntity<EmailDto>(emailDto);
			ResponseEntity<String> response=restTemplate.exchange("http://localhost:8080/emailengine/mails", HttpMethod.POST, ent, String.class, customerRequestDto.getEmail());
			ResponseDto responseDto = new ResponseDto();
			responseDto.setMessage(ApplicationConstant.REGISTRED_SUCCESSFULLY);
			responseDto.setStatusCode(HttpStatus.ACCEPTED.value());
			return responseDto;
	}

}
