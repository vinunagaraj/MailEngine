package com.geekyants.mailengine.service;

import java.util.Date;
import java.util.Locale;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.geekyants.mailengine.constant.ApplicationConstant;
import com.geekyants.mailengine.controller.EmailDto;
import com.geekyants.mailengine.entity.Customer;
import com.geekyants.mailengine.entity.TemplateDetail;
import com.geekyants.mailengine.exception.NotFoundException;
import com.geekyants.mailengine.repository.CustomerRepository;
import com.geekyants.mailengine.repository.TemplateDetailRepository;

@Service
public class EmailServiceImpl implements EmailService{

	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private TemplateEngine templateEngine;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private TemplateDetailRepository templateDetailRepository;
	
	@Override
	public void sendMailForCustomerCreation(EmailDto emailDto, Locale locale) throws MessagingException, NotFoundException {
		Optional<Customer> customer=customerRepository.findById(emailDto.getCustomerId());
		if(!customer.isPresent()) {
			throw new NotFoundException(ApplicationConstant.CUSTOMER_NOT_FOUND);
		}
		TemplateDetail template=templateDetailRepository.findByTemplateName(emailDto.getPurpose());
		 Context ctx = new Context(locale);
		    ctx.setVariable("name", customer.get().getCustomerName());
		    ctx.setVariable("subscriptionDate", new Date());
		    final MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		    final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8"); 
		    message.setSubject("Customer created");
		    message.setFrom("thymeleaf@example.com");
		    message.setTo(customer.get().getEmail());
		    final String htmlContent = templateEngine.process(template.getFilePath(), ctx);
		    message.setText(htmlContent, true);
		    javaMailSender.send(mimeMessage);
	}
}
