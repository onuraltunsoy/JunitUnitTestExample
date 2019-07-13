package com.altunsoy.customer;

public class NotifiCationService {

	public void sendMailforNewRegistry(Customer customer) {
		System.out.println("Sended Mail");
	}
	public void sendMailWeekly(){
		throw new MailServerUnvailableExcepiton("mail server has error");
	}
	public void sendWelcomeNotification(String customerName, String email) {
		System.out.println("Welcome"+customerName);
		
	}
}
