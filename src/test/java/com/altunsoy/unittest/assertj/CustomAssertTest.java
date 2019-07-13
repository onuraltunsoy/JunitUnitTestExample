package com.altunsoy.unittest.assertj;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import junit.framework.Assert;
import com.altunsoy.customer.Customer;
import com.altunsoy.customer.CustomerRepository;
import com.altunsoy.customer.CustomerService;
import com.altunsoy.customer.NotifiCationService;


public class CustomAssertTest {
	private CustomerRepository customerRepository;
	private NotifiCationService notificationService; 
	private CustomerService customerService;
	public static final String USERNAME="onur";
	public static final String EMAIL="onur@onur.com";

	@Before
	public void setUp() {
		customerService  = new CustomerService();
		customerRepository = Mockito.mock(CustomerRepository.class);
		notificationService = Mockito.mock(NotifiCationService.class);
		
		customerService.setNotifiCationService(notificationService);
		customerService.setCustomerRepository(customerRepository);
		
	}


	@Test
	public void testCustomAssertJunit() throws Exception {
		Customer customer = customerService.handleNewCustomer(USERNAME,EMAIL);
		
		Mockito.verify(customerRepository).save(Mockito.any(Customer.class));
		Mockito.verify(notificationService).sendWelcomeNotification(USERNAME,EMAIL);
		Assert.assertNotNull(customer.getGifts());
		Assert.assertEquals(2, customer.getGifts().size());
		Assert.assertEquals("welcome1", customer.getGifts().get(0).getName());
		Assert.assertEquals("welcome2", customer.getGifts().get(1).getName());

	}
	@Test
	public void testCustomAssert() {
		Customer customer = customerService.handleNewCustomer(USERNAME,EMAIL);
		assertThatCustomer(customer)
						.hasGifts(2)
						.hasGiftWithName("welcome1")
						.hasGiftWithName("welcome2")
						.isSaved()
						.customerAssert()
						;
	}

	private CustomerAssert assertThatCustomer(Customer customer) {
		
		return new CustomerAssert(customer, CustomerAssert.class, customerRepository,notificationService);
	}
}
