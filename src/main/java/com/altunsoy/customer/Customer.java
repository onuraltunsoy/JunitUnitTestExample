package com.altunsoy.customer;


import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
	public Customer(int id) {
		super();
		this.id = id;
		 gifts  = new ArrayList<Gift>();
	}

	public Customer(String userName, String email) {
		this.userName = userName;
		this.email = email;
		gifts  = new ArrayList<Gift>();
	}

	private int id;
	private String userName;
	private String email;
	private List<Gift> gifts ;

	public void addGift(Gift gift) {
		this.gifts.add(gift);

	}

}
