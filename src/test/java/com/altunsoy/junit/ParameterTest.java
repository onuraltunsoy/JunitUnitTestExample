package com.altunsoy.junit;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.altunsoy.UnitTesteExample.HesapMakinesi;


@RunWith(Parameterized.class)
public class ParameterTest {
	///JunitParams Framework
	private int en;
	private int boy;
	private int toplamMetreKare;
	private HesapMakinesi hesapMakinesi;

	@Parameterized.Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{10,2,20},
			{30,5,150},
			{3,90,270}
		});
	}
	public ParameterTest(int en, int boy, int toplamMetreKare) {
		this.en = en;
		this.boy = boy;
		this.toplamMetreKare = toplamMetreKare;
		 hesapMakinesi = new HesapMakinesi();
	}
	
	@Test
	public void testMetrekareHesapla() throws Exception {
		assertEquals(toplamMetreKare,hesapMakinesi.metrekareHesapla(en,boy));
	}
}
