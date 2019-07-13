package com.altunsoy.junit;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.altunsoy.UnitTesteExample.Calculator;


@RunWith(Parameterized.class)
public class ParameterTest {
	///JunitParams Framework
	private int width, height;
	private int toplamMetreKare;
	private Calculator hesapMakinesi;

	@Parameterized.Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{10,2,20},
			{30,5,150},
			{3,90,270}
		});
	}
	public ParameterTest(int width,int height, int toplamMetreKare) {
		this.width = width;
		this.height = height;
		this.toplamMetreKare = toplamMetreKare;
		 hesapMakinesi = new Calculator();
	}
	
	@Test
	public void testMetrekareHesapla() throws Exception {
		assertEquals(toplamMetreKare,hesapMakinesi.calculateCentare(width, height));
	}
}
