package com.geekyants.mailengine.service;

import java.util.Locale;

import javax.mail.MessagingException;

public interface EmailService {

	void sendMailForCustomerCreation(String recipientName, String recipientEmail) throws MessagingException;

}
