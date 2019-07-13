package com.altunsoy.unittest.assertj;




import static org.junit.Assert.assertThat;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;
import org.mockito.Mockito;

import com.altunsoy.customer.Customer;
import com.altunsoy.customer.CustomerRepository;
import com.altunsoy.customer.NotifiCationService;

public class CustomerAssert extends AbstractAssert<CustomerAssert,Customer> {
	
	private CustomerRepository customerRepository;
	private NotifiCationService notifiCationService;
	public CustomerAssert(Customer actual, Class<?> selfType,CustomerRepository customerRepository,NotifiCationService notifiCationService ) {
		super(actual, selfType);
		
		isNotNull();
		this.customerRepository = customerRepository;
		this.notifiCationService = notifiCationService;
	}

	public CustomerAssert hasGifts(int sizeOfGitfs) {

		Assertions.assertThat(actual.getGifts())
							.isNotEmpty()
							.hasSize(sizeOfGitfs);
		return this;
	}

	public CustomerAssert hasGiftWithName(String giftName) {
		Assertions.assertThat(actual.getGifts())
						.isNotEmpty()
						.extracting("name")
							.contains(giftName);
		return this;
	}

	public CustomerAssert isSaved() {
		
		Mockito.verify(customerRepository).save(Mockito.any(Customer.class));
		
		return this;
		
	}

	public CustomerAssert customerAssert() {
		
		Mockito.verify(notifiCationService).sendWelcomeNotification(CustomAssertTest.USERNAME, CustomAssertTest.EMAIL);
		
		return this;
	}

}
