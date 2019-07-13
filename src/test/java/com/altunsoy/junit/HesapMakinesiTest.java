package com.altunsoy.junit;

import org.junit.Test;

import com.altunsoy.UnitTesteExample.HesapMakinesi;

import junit.framework.Assert;

public class HesapMakinesiTest {
	
	@Test
	public void testTopla() {
		HesapMakinesi makine = new HesapMakinesi();
		int sayi1 = 5;
		int sayi2 = 19;
		int toplam = makine.topla(sayi1, sayi2);
		Assert.assertEquals(24, toplam);
	}
	@Test
	public void testHesapMakinesi() { /// her test metounda bir metod test edilir
		
		HesapMakinesi makine = new HesapMakinesi();
		int sayi1 = 5;
		int sayi2 = 19;
		int toplam = makine.topla(sayi1, sayi2);
		Assert.assertEquals(24, toplam);
		int cikartSonuc = makine.cikart(sayi1, sayi2);
		Assert.assertEquals(-14,cikartSonuc);
	}
	@Test
	public void testSifirdanSayiCikincaNegatifDeğerCikar() {
		HesapMakinesi makine = new HesapMakinesi();

		Assert.assertEquals(-15, makine.cikart(0, 15));

	}
	@Test
	public void testSayidanSifirCıkıncaAyniSayiKalir() {
		HesapMakinesi makine = new HesapMakinesi();

		Assert.assertEquals(15, makine.cikart(15, 0));

	}
}
