package com.altunsoy.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.altunsoy.UnitTesteExample.HesapMakinesi;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class AssertJunitParamsTest {
	
	private HesapMakinesi  hesapMakinesi = new HesapMakinesi();
	
	@Test
	@Parameters("10,2,20")
	public void testMetrekareHesapla(int en,int boy,int toplamMetreKare) throws Exception {
		assertEquals(toplamMetreKare,hesapMakinesi.metrekareHesapla(en,boy));
	}
}
