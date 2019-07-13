package com.altunsoy.junit;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.altunsoy.customer.MailServerUnvailableExcepiton;
import com.altunsoy.customer.NotifiCationService;

public class ExceptionTest {

	private NotifiCationService bilgilendirmeService = new NotifiCationService();

	@Test
	public void testTryCatchException() {
		try {
			bilgilendirmeService.sendMailWeekly();
		} catch (Exception ex) {
			assertTrue(ex instanceof MailServerUnvailableExcepiton);
			assertEquals("mail server hata veriyor", ex.getMessage());
		}
	}

	@Test(expected = MailServerUnvailableExcepiton.class)
	public void testExpectedException() {
		bilgilendirmeService.sendMailWeekly();
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testRuleException() throws Exception {
		thrown.expect(MailServerUnvailableExcepiton.class);
		thrown.expectMessage("mail server has error");

		bilgilendirmeService.sendMailWeekly();

	}
}
