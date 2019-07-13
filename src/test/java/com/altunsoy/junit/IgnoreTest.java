package com.altunsoy.junit;

import org.junit.Ignore;
import org.junit.Test;

public class IgnoreTest {
	@Test
	public void sayHello() {
		System.out.println("Hello");
	}
	@Test
	@Ignore("Bu metod daha sonra kullanılacak")
	public void sayHello2() {
		System.out.println("Hello 2");
	}
}
