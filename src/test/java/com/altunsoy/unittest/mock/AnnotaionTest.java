package com.altunsoy.unittest.mock;

import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.altunsoy.customer.Customer;
import com.altunsoy.customer.CustomerRepository;
import com.altunsoy.customer.CustomerService;
import com.altunsoy.customer.NotifiCationService;

@RunWith(MockitoJUnitRunner.class)
public class AnnotaionTest {
	
	@Mock
	private DummyCustomerService dummyCustomerService;
	@Spy
	private DummyCustomerServiceImpl dummyCustomerServiceImpl;/// spylar interface yada abstrack olamaz
	
	@InjectMocks /// sınıftaki spy ve mock nesnelerini inject et 
	private CustomerService customerService;
	@Mock
	private CustomerRepository customerRepository;
	@Mock
	private NotifiCationService notifiCationService;
	/*@Before
	public void setUp(){
		customerService = new CustomerService();
		customerRepository = Mockito.mock(CustomerRepository.class);
		notifiCationService = Mockito.mock(NotifiCationService.class);
		customerService.setCustomerRepository(customerRepository);
		customerService.setNotifiCationService(notifiCationService);
	}*/////@InjectMocks ve spy ile setup etmeye gerek kalmadı 
	
	/**@Before
	public void setUp(){
		dummyCustomerService =  mock(DummyCustomerService.class);
	}*/// Buna gerek kalmadı
	
	@Test
	public void testAnnotationMock() throws Exception{
		dummyCustomerService.addCustomer("istanbul");
	}
	@Test
	public void testAnnotationSpy() throws Exception{
		dummyCustomerServiceImpl.addCustomer("istanbul");
	}
	@Test
	public void testAnnotationCustomer() throws Exception{
		customerService.handleNewCustomer("istanbul", "istanbul@istanbul.com");
	}
}
