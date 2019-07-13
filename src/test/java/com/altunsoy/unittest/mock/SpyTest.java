package com.altunsoy.unittest.mock;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.spy;

import org.junit.Test;

public class SpyTest {

	@Test
	public  void testSpy() throws Exception{
		
		/// spy nesneler her zaman gerçek nesneleri çağırır davranışlarında mock verilebilr 
		DummyCustomerService service = spy(new DummyCustomerServiceImpl());
		// spy a davranış eklendi
		doNothing().when(service).addCustomer("istanbul");/// sadece istanbul için geçerli mockdavranışı yanımlandı service.addCustomer("ankara"); da addCustomer(ankara) yazayr
		
		
		/// remove customer çağrıldıpında hata ver
		doThrow(new IllegalArgumentException()).when(service).removeCustomer(anyString());
		
		service.addCustomer("ankara");
		service.removeCustomer("ankara");

	}
	@Test
	public  void testSpyRemove() throws Exception{
		
		/// spy nesneler her zaman gerçek nesneleri çağırır davranışlarında mock verilebilr 
		DummyCustomerService service = spy(new DummyCustomerServiceImpl());

		
		/// remove customer çağrıldığında hata ver
		doThrow(new IllegalArgumentException()).when(service).removeCustomer(anyString());
		
		service.removeCustomer("lkznxlvk nlvk");

	}
	@Test
	public  void testdoCAllRealMethod() throws Exception{
		
		/// spy nesneler her zaman gerçek nesneleri çağırır davranışlarında mock verilebilr 
		DummyCustomerService service = spy(new DummyCustomerServiceImpl());

		doNothing().when(service).removeCustomer("istanbul1");
		doNothing().when(service).removeCustomer("istanbul2");
		///doCallRealMethod().when(service).removeCustomer("istanbul3");/// bu satırı çıkarsak bile removeCustomer(istanbul3)yazıp gerçek nsne çalışır spylar gerçek nesneyi çalıştırır
		
		service.removeCustomer("istanbul1");
		service.removeCustomer("istanbul2");
		service.removeCustomer("istanbul3");////consola removeCustomer(istanbul3) yazıp gerçek method çalışır

	}
	
	
}
