package com.altunsoy.customer;

public class CustomerRepository {
	public void save(Customer customer) {
		System.err.println("db save");
	}
	public void  delete(Integer customerId) {
		System.err.println("db delete");
	}
	public Customer find(Integer customerId) {
		System.err.println("db find");
		return null;
	}
}
