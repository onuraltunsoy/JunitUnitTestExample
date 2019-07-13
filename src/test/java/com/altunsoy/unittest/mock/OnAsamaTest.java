package com.altunsoy.unittest.mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.management.RuntimeErrorException;

import org.junit.Test;

public class OnAsamaTest {
	@Test
	public void testWhen() {
		DummyCustomerService service = mock(DummyCustomerService.class);
		/// get customer çağrıldığında customerItanbul dön
		///when(service.getCustomer(anyString())).thenReturn("customerIstanbul");
		
		
		/// ankara parametre verilirse
		when(service.getCustomer(eq("istanbul"))).thenReturn("customerIstanbul");
		
		String customer = service.getCustomer("istanbul");		
		
		assertThat(customer).isEqualTo("customerIstanbul");
	}
	@Test
	public void whenthenthrow() {
		DummyCustomerService service = mock(DummyCustomerService.class);
		
		/// giresun parametre verilirse runtimeexception atılır 
		when(service.getCustomer(eq("giresun"))).thenThrow(new RuntimeException());
		
		String customer = service.getCustomer("giresun");		
		
	}
	@Test
	public void doNothing() {
		DummyCustomerService service = mock(DummyCustomerService.class);

		/// void dönen metodlarda do Nothing kullanılır
		////doNothing().when(service).addCustomer("istanbul");
		doThrow(new RuntimeException()).when(service).addCustomer(anyString());
		
		doReturn("ankara").when(service).getCustomer("istanbul");
	}
	
}
