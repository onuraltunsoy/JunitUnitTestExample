package com.altunsoy.customer;

import lombok.Setter;

@Setter
public class CustomerService {

	private CustomerRepository customerRepository;
	private NotifiCationService notifiCationService;
	

	public CustomerRepository getMusteriRepository() {
		return customerRepository;
	}
	public void deletecustomer(Integer musteriId) {
		customerRepository.delete(musteriId);
	}

	public void saveCustomer(Customer customer) {
		customerRepository.save(customer);
		notifiCationService.sendMailforNewRegistry(customer);
	}

	public Customer handleNewCustomer(String customerName, String email) {
		
		Customer customer = new Customer(customerName,email);
		
		giveWelcomeGifts(customer);
		customerRepository.save(customer);
		notifiCationService.sendWelcomeNotification(customerName,email);
		return customer;
	}
	private void giveWelcomeGifts(Customer customer) {
		customer.addGift(new Gift("welcome1"));
		customer.addGift(new Gift("welcome2"));
		
	}
}
