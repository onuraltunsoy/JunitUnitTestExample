package com.altunsoy.customer;

import java.util.HashMap;
import java.util.Map;

public class MusteriRepositoryStub extends CustomerRepository {
	private Map<Integer,Customer> customerList = new HashMap<Integer,Customer>();


	public void setMusteriListesi(Map<Integer, Customer> customerList) {
		this.customerList = customerList;
	}

	@Override
	public void save(Customer customer) {
		// TODO Auto-generated method stub
		customerList.put(customer.getId(),customer);
	}
	public Customer bul(Integer musteriId) {
		return customerList.get(musteriId);
	}
	@Override
	public void delete(Integer customerId) {
		// TODO Auto-generated method stub
		customerList.remove(customerId);
	}

	public void herseyiSil() {
		customerList.clear();
		
	}
}
