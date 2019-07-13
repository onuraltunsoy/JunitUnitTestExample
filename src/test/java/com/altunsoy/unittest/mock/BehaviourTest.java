package com.altunsoy.unittest.mock;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

public class BehaviourTest {
	@Test
	public void testBehaviour() {
		DummyCustomerService customerService = Mockito.mock(DummyCustomerService.class);
		customerService.addCustomer("istanbul");
		customerService.addCustomer("ankara");
		verify(customerService).addCustomer("istanbul");
		verify(customerService).addCustomer("ankara");
		//// verify(customerService).addCustomer("izimir");// hatalı

	}

	@Test
	public void testKacDefaCagrildi() {
		DummyCustomerService customerService = Mockito.mock(DummyCustomerService.class);
		customerService.addCustomer("istanbul");
		customerService.addCustomer("istanbul");
		customerService.addCustomer("istanbul");
		customerService.addCustomer("ankara");

		verify(customerService, times(3)).addCustomer("istanbul");
		verify(customerService, times(1)).addCustomer("ankara");
		/// remove customerin hiç çağrılmadıpnı kontrol ediyoruz parametre önemsiz
		verify(customerService, never()).removeCustomer(anyString());
		/// izmir ile hiç kaydedilmedi kontrol
		verify(customerService, never()).addCustomer("izmir");
		/// en az iki kere çağrıldı
		verify(customerService, atLeast(1)).addCustomer("ankara");

	}
	@Test
	public void testSirasiniKontrolEt() {
		DummyCustomerService customerService = Mockito.mock(DummyCustomerService.class);
		customerService.addCustomer("istanbul");
		customerService.addCustomer("izmir");
		customerService.updateCustomer("ankara");
		//// sıra kontrolu yap
		InOrder inOrder = Mockito.inOrder(customerService);
		inOrder.verify(customerService).addCustomer("istanbul");
		inOrder.verify(customerService).addCustomer("izmir");
		inOrder.verify(customerService).updateCustomer("ankara");
	}
	@Test
	public void testVerifyNoMore() {
		DummyCustomerService customerService = Mockito.mock(DummyCustomerService.class);
		customerService.addCustomer("istanbul");
		customerService.addCustomer("ankara");
		customerService.addCustomer("izmir");////çağrılırsa  verifyNore metodu hata olur 
		
		verify(customerService).addCustomer("istanbul");
		verify(customerService).addCustomer("ankara");
		
		verifyNoMoreInteractions(customerService);//// başka  çağrılma olmasın ,sadece verdiklerim

	}
	@Test
	public void testVerifyZeroInteractions() {
		DummyCustomerService customerService = Mockito.mock(DummyCustomerService.class);
		/////customerService.addCustomer("istanbul");
		
		


		
		verifyZeroInteractions(customerService); /// hiçbir şekilde bu mock nesnesi çağrılmasın

	}
}
