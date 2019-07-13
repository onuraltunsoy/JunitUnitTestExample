package com.altunsoy.junit;

import org.junit.Test;

import com.altunsoy.UnitTesteExample.Calculator;

import junit.framework.Assert;

public class CalculatorTest {
	
	@Test
	public void testAdd() {
		Calculator calc = new Calculator();
		int num1 = 5;
		int num2 = 19;
		int total = calc.add(num1, num2);
		Assert.assertEquals(24, total);
	}
	@Test
	public void testCalculator() { 
		
		Calculator calc = new Calculator();
		int num1 = 5;
		int num2 = 19;
		int totalAdd = calc.add(num1,num2);
		Assert.assertEquals(24, totalAdd);
		int totalSub = calc.sub(num1, num2);
		Assert.assertEquals(-14,totalSub);
	}
	@Test
	public void WhenSubFromZeroThenResultNegative() {
		Calculator calc = new Calculator();

		Assert.assertEquals(-15, calc.sub(0, 15));

	}

}
