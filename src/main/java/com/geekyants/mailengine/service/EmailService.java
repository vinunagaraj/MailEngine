package com.geekyants.mailengine.service;

import java.util.Locale;

import javax.mail.MessagingException;

import com.geekyants.mailengine.dto.EmailDto;
import com.geekyants.mailengine.exception.NotFoundException;

public interface EmailService {

	void sendMailForCustomerCreation(EmailDto emailDto, Locale locale) throws MessagingException, NotFoundException;

}
