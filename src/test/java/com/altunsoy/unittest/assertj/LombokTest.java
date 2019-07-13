package com.altunsoy.unittest.assertj;


import org.junit.Test;

import com.altunsoy.customer.Gift;

public class LombokTest {
	
	@Test
	public void testlombok() throws Exception{
		Gift gift = new Gift("onur");
		System.out.println( gift.toString()); 
		gift = Gift.builder().name("altunsoy").build();
		System.out.println( gift.toString()); 

	}
}
