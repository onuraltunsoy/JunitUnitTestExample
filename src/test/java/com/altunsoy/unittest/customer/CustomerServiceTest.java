package com.altunsoy.unittest.customer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.altunsoy.customer.Customer;
import com.altunsoy.customer.CustomerService;
import com.altunsoy.customer.MusteriRepositoryStub;
import com.altunsoy.customer.NotifiCationService;
/**
 * Stub kullanımında her türlü silme kaydetme işlemlerinde problem oluşturdu
 * test edilmek istenen şey müşterinin gerçekten aili aldığı veya db ye  kayıt işleminin gerçekleşmesi değil
 *  dış bağımlılıkların doğru bir şekilde çağrılıp çağrılmadığır.Buradaki sorumluluk servis sınıfının işleyişinin kontrlünü yapmaktır.
 *  Dışında kalan şeyler farklı test sınıflarında test edilmelidir 
 */


public class CustomerServiceTest {
	private CustomerService musteriService;
	private MusteriRepositoryStub customerRepository = new MusteriRepositoryStub();
	private NotifiCationService notifiCationService;

	@Before
	public void setUp() throws Exception {
		musteriService = new CustomerService();
		notifiCationService = Mockito.mock(NotifiCationService.class);	
		musteriService.setCustomerRepository(customerRepository);
		musteriService.setNotifiCationService(notifiCationService);
	}
	@After
	public void after() {
		customerRepository.herseyiSil();
	}
	@Test
	public void testMusteriKaydet() {
		Customer customer = new Customer(1234);
		musteriService.saveCustomer(customer);
		assertEquals(customer,customerRepository.bul(customer.getId()));
		Mockito.verify(notifiCationService).sendMailforNewRegistry(customer);
		musteriService.deletecustomer(234);
	}
	@Test
	public void testMusteriKaydetMailHatali() {
		///1234 silinemediği için 1234 müsterisi iki defa eklenebilir
		Customer customer = new Customer(1234);
		musteriService.saveCustomer(customer);
		assertEquals(customer,customerRepository.bul(customer.getId()));
		Mockito.verify(notifiCationService).sendMailforNewRegistry(new Customer(3456));
		////musteriService.musteriSil(1234); after sil ekledikten sonra artık gerek kalmadı 
	}
	@Test
	public void testCustomerDelete() {
		musteriService.saveCustomer(new Customer(1234));

		musteriService.deletecustomer(1234);

		assertNull(customerRepository.bul(1234));
	}
}
